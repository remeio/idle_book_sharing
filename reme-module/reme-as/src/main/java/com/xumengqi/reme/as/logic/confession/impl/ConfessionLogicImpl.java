package com.xumengqi.reme.as.logic.confession.impl;

import com.xumengqi.reme.as.logic.confession.ConfessionLogic;
import com.xumengqi.reme.as.mapper.ConfessionExtMapper;
import com.xumengqi.reme.as.vo.ConfessionVO;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.YesOrNoEnum;
import com.xumengqi.reme.dao.entity.*;
import com.xumengqi.reme.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private ConfessionExtMapper confessionExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addConfession(Confession confession, Set<Long> attachIds) {
        if (!CollectionUtils.isEmpty(attachIds)) {
            AttachExample attachExample = new AttachExample();
            attachExample.createCriteria().andAttachIdIn(new ArrayList<>(attachIds));
            List<Attach> attachList = attachMapper.selectByExample(attachExample);
            // 上传附件均存在
            AssertUtils.asserter().assertTrue(attachList.size() == attachIds.size()).elseThrow(ErrorCodeEnum.ATTACH_NOT_EXIST);
            // 上传附件必须都是来自此用户
            Long userId = confession.getUserId();
            attachList.stream()
                    .map(Attach::getUserId)
                    .distinct()
                    .filter(e -> !e.equals(userId)).findAny()
                    .ifPresent(aLong -> BizException.error(ErrorCodeEnum.ATTACH_NO_PERMISSION));
        }
        // 表白标签必须存在
        AssertUtils.asserter().assertNotNull(confessionTagMapper.selectByPrimaryKey(confession.getConfessionTagId()))
                .elseThrow(ErrorCodeEnum.CONFESSION_TAG_NOT_EXIST);
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

    @Override
    public List<ConfessionVO> listConfessionBySchoolId(Long schoolId, Set<Long> confessionTagIdSet, Integer isSolved) {
        return confessionExtMapper.selectBySchoolId(schoolId, isSolved, confessionTagIdSet);
    }

    @Override
    public List<Confession> listConfessionByUserId(Long userId, Set<Long> confessionTagIdSet, Integer isSolved) {
        assert userId != null;
        return confessionExtMapper.selectByUserId(userId, isSolved, confessionTagIdSet);
    }


    @Override
    public void checkListConfessionParameter(Long schoolId, Long userId, Set<Long> confessionTagIdSet, Integer isSolved) {
        ConfessionExample confessionExample = new ConfessionExample();
        ConfessionExample.Criteria criteria = confessionExample.createCriteria();
        if (schoolId != null) {
            // 判断学校是否存在
            AssertUtils.asserter().assertNotNull(schoolMapper.selectByPrimaryKey(schoolId)).elseThrow(ErrorCodeEnum.SCHOOL_NOT_EXIST);
        }
        if (isSolved != null) {
            AssertUtils.asserter().assertTrue(YesOrNoEnum.isYesOrNo(isSolved)).elseThrow(ErrorCodeEnum.NOT_YES_OR_NO);
        }
        if (confessionTagIdSet.size() != 0) {
            // 判断标签是否正确
            ConfessionTagExample confessionTagExample = new ConfessionTagExample();
            confessionTagExample.createCriteria()
                    .andConfessionTagIdIn(new ArrayList<>(confessionTagIdSet));
            AssertUtils.asserter().assertTrue(confessionTagMapper.countByExample(confessionTagExample) == confessionTagIdSet.size())
                    .elseThrow(ErrorCodeEnum.CONFESSION_TAG_NOT_EXIST);
            criteria.andConfessionTagIdIn(new ArrayList<>(confessionTagIdSet));
        }
        if (userId != null) {
            // 判断用户是否存在
            User user = userMapper.selectByPrimaryKey(userId);
            AssertUtils.asserter().assertNotNull(user).elseThrow(ErrorCodeEnum.USER_NOT_EXISTS);
        }
    }

}
