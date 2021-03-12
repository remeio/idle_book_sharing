package com.xumengqi.reme.as.mapper;

import com.xumengqi.reme.as.vo.ConfessionVO;
import com.xumengqi.reme.dao.entity.Confession;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author xumengqi
 * @date 2021/3/11 16:03
 */
public interface ConfessionExtMapper {

    /**
     * 查询某学校的表白记录
     * @param schoolId 可空
     * @param isSolved 可空
     * @param confessionTagIdSet 可空
     * @return /
     */
    List<ConfessionVO> selectBySchoolId(@Param("schoolId") Long schoolId, @Param("isSolved") Integer isSolved, @Param("confessionTagIdSet") Set<Long> confessionTagIdSet);

    /**
     * 获取某用户的表白记录
     * @param userId 不可空
     * @param isSolved 可空
     * @param confessionTagIdSet 可空
     * @return /
     */
    List<Confession> selectByUserId(@Param("userId") Long userId, @Param("isSolved") Integer isSolved, @Param("confessionTagIdSet") Set<Long> confessionTagIdSet);
}
