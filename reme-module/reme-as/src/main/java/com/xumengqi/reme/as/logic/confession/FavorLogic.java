package com.xumengqi.reme.as.logic.confession;

import com.xumengqi.reme.as.vo.FavorVO;
import com.xumengqi.reme.dao.entity.Favor;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xumengqi
 * @date 2021/3/11 22:24
 */
public interface FavorLogic {

    /**
     * 获取表白列表的点赞量
     * @param confessionIdSet /
     * @param userId /
     * @return /
     */
    List<FavorVO> mapFavorOfConfession(Set<Long> confessionIdSet, Long userId);
}
