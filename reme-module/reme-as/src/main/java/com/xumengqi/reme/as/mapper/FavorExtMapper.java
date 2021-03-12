package com.xumengqi.reme.as.mapper;

import com.xumengqi.reme.as.vo.FavorVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xumengqi
 * @date 2021/3/11 22:28
 */
public interface FavorExtMapper {
    /**
     * 获取表白的点赞记录
     * @param confessionIdSet /
     * @return /
     */
    List<FavorVO> mapFavorOfConfession(@Param("confessionIdSet") Set<Long> confessionIdSet, @Param("userId") Long userId);
}
