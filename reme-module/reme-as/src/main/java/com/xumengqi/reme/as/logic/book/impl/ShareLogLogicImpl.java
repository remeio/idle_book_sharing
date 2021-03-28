package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.ShareLogLogic;
import com.xumengqi.reme.dao.entity.ShareLog;
import com.xumengqi.reme.dao.entity.ShareLogExample;
import com.xumengqi.reme.dao.mapper.ShareLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/28 14:08
 */
@Component
public class ShareLogLogicImpl implements ShareLogLogic {
    @Autowired
    private ShareLogMapper shareLogMapper;

    @Override
    public List<ShareLog> getShareLogListByShareRecordId(Long shareRecordId) {
        ShareLogExample shareLogExample = new ShareLogExample();
        shareLogExample.createCriteria().andShareRecordIdEqualTo(shareRecordId);
        return shareLogMapper.selectByExample(shareLogExample);
    }
}
