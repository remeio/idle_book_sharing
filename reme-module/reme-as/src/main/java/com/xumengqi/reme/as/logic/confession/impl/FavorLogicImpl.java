package com.xumengqi.reme.as.logic.confession.impl;

import com.xumengqi.reme.as.logic.confession.FavorLogic;
import com.xumengqi.reme.as.mapper.FavorExtMapper;
import com.xumengqi.reme.as.vo.FavorVO;
import com.xumengqi.reme.common.enums.YesOrNoEnum;
import com.xumengqi.reme.dao.entity.FavorExample;
import com.xumengqi.reme.dao.mapper.FavorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author xumengqi
 * @date 2021/3/11 22:26
 */
@Component
public class FavorLogicImpl implements FavorLogic {
    @Autowired
    private FavorExtMapper favorExtMapper;

    @Override
    public List<FavorVO> mapFavorOfConfession(Set<Long> confessionIdSet, Long userId) {
        return favorExtMapper.mapFavorOfConfession(Optional.ofNullable(confessionIdSet).orElse(new HashSet<>()), userId);
    }
}
