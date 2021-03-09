package com.xumengqi.reme.as.logic.confession.impl;

import com.xumengqi.reme.as.logic.confession.ConfessionLogic;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.YesOrNoEnum;
import com.xumengqi.reme.dao.entity.Attach;
import com.xumengqi.reme.dao.entity.AttachExample;
import com.xumengqi.reme.dao.entity.Confession;
import com.xumengqi.reme.dao.entity.ConfessionAttach;
import com.xumengqi.reme.dao.mapper.AttachMapper;
import com.xumengqi.reme.dao.mapper.ConfessionAttachMapper;
import com.xumengqi.reme.dao.mapper.ConfessionMapper;
import com.xumengqi.reme.dao.mapper.ConfessionTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xumengqi
 * @date 2021/3/8 18:14
 */
@Component
public class ConfessionLogicImpl implements ConfessionLogic {
    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private ConfessionTagMapper confessionTagMapper;

    @Autowired
    private ConfessionAttachMapper confessionAttachMapper;

    @Autowired
    private ConfessionMapper confessionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addConfession(Confession confession, Set<Long> attachIds) {
        if (attachIds == null) {
            attachIds = new HashSet<>();
        }
        AttachExample attachExample = new AttachExample();
        attachExample.createCriteria().andAttachIdIn(new ArrayList<>(attachIds));
        List<Attach> attachList = attachMapper.selectByExample(attachExample);
        // 上传附件均存在
        AssertUtils.isTrue(attachList.size() == attachIds.size(), ErrorCodeEnum.ATTACH_NOT_EXIST);
        // 上传附件必须都是来自此用户
        Long userId = confession.getUserId();
        attachList.stream()
                .map(Attach::getUserId)
                .distinct()
                .filter(e -> !e.equals(userId)).findAny()
                .ifPresent(aLong -> BizException.error(ErrorCodeEnum.ATTACH_NO_PERMISSION));
        // 表白标签必须存在
        AssertUtils.isNotNull(confessionTagMapper.selectByPrimaryKey(confession.getConfessionTagId()), ErrorCodeEnum.CONFESSION_TAG_NOT_EXIST);
        // 插入表白记录
        confession.setIsSolved(YesOrNoEnum.NO.getCode());
        Date now = new Date();
        confession.setGmtCreate(now);
        confession.setGmtModified(now);
        confessionMapper.insertSelective(confession);
        // 插入附件列表
        AtomicInteger order = new AtomicInteger(1);
        attachIds.forEach(aLong -> {
            ConfessionAttach confessionAttach = new ConfessionAttach();
            confessionAttach.setAttachId(aLong);
            confessionAttach.setConfessionId(confession.getConfessionId());
            confessionAttach.setAttachOrder(order.getAndIncrement());
            confessionAttachMapper.insertSelective(confessionAttach);
        });
    }
}
