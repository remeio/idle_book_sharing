package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookcaseLogic;
import com.xumengqi.reme.as.mapper.BookcaseExtMapper;
import com.xumengqi.reme.as.vo.BookcaseVO;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.Bookcase;
import com.xumengqi.reme.dao.mapper.BookcaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/29 22:39
 */
@Component
public class BookcaseLogicImpl implements BookcaseLogic {
    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Autowired
    private BookcaseExtMapper bookcaseExtMapper;

    @Override
    public void add(Long bookId, Long userId) {
        Bookcase record = new Bookcase();
        record.setUserId(userId);
        record.setBookId(bookId);
        record.setGmtCreate(new Date());
        bookcaseMapper.insert(record);
    }

    @Override
    public void delete(Long bookcaseId, Long userId) {
        // 判断书箱记录存在与否
        Bookcase bookcase = bookcaseMapper.selectByPrimaryKey(bookcaseId);
        AssertUtils.asserter()
                .assertNotNull(bookcase)
                .elseThrow(ErrorCodeEnum.BOOKCASE_NOT_EXIT);
        // 判断是否有权限
        AssertUtils.asserter().
                assertEqual(bookcase.getUserId(), userId)
                .elseThrow(ErrorCodeEnum.PERMISSION_DENIED);
        // 删除
        bookcaseMapper.deleteByPrimaryKey(bookcaseId);
    }

    @Override
    public List<BookcaseVO> getListByUserId(Long userId) {
        return bookcaseExtMapper.selectByUserId(userId);
    }
}
