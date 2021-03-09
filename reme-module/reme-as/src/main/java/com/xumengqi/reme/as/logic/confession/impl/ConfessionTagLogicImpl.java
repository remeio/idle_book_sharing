package com.xumengqi.reme.as.logic.confession.impl;

import com.xumengqi.reme.as.logic.confession.ConfessionTagLogic;
import com.xumengqi.reme.dao.entity.ConfessionTag;
import com.xumengqi.reme.dao.entity.ConfessionTagExample;
import com.xumengqi.reme.dao.mapper.ConfessionTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/9 17:54
 */
@Component
public class ConfessionTagLogicImpl implements ConfessionTagLogic {
    @Autowired
    private ConfessionTagMapper confessionTagMapper;

    @Override
    public List<ConfessionTag> getConfessionTagList() {
        return confessionTagMapper.selectByExample(new ConfessionTagExample());
    }
}
