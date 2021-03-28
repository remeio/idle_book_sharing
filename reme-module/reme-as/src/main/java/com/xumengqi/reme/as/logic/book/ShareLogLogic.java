package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.dao.entity.ShareLog;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/26 19:24
 */
public interface ShareLogLogic {

    /**
     * 根据共享记录ID查询共享日志
     *
     * @param shareRecordId /
     * @return /
     */
    List<ShareLog> getShareLogListByShareRecordId(Long shareRecordId);
}
