package com.xumengqi.reme.as.logic.confession;

import com.xumengqi.reme.as.vo.ConfessionVO;
import com.xumengqi.reme.dao.entity.Confession;

import java.util.List;
import java.util.Set;

/**
 * @author xumengqi
 * @date 2021/3/8 18:14
 */
public interface ConfessionLogic {
    /**
     * 添加表白记录
     *
     * @param confession /
     * @param attachIds  /
     */
    void addConfession(Confession confession, Set<Long> attachIds);

    /**
     * 获取某学校的表白记录
     *
     * @param schoolId           /
     * @param confessionTagIdSet /
     * @param isSolved           /
     * @return /
     */
    List<ConfessionVO> listConfessionBySchoolId(Long schoolId, Set<Long> confessionTagIdSet, Integer isSolved);

    /**
     * 检查获取表白列表参数
     *
     * @param schoolId           /
     * @param userId             /
     * @param confessionTagIdSet /
     * @param isSolved           /
     */
    void checkListConfessionParameter(Long schoolId, Long userId, Set<Long> confessionTagIdSet, Integer isSolved);

    /**
     * 获取某用户的表白记录
     *
     * @param confessionTagIdSet /
     * @param isSolved           /
     * @param userId             /
     * @return /
     */
    List<Confession> listConfessionByUserId(Long userId, Set<Long> confessionTagIdSet, Integer isSolved);
}
