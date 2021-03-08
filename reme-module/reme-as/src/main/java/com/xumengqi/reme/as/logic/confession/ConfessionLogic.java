package com.xumengqi.reme.as.logic.confession;

import com.xumengqi.reme.dao.entity.Confession;

import java.util.List;

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
    void addConfession(Confession confession, List<Long> attachIds);
}
