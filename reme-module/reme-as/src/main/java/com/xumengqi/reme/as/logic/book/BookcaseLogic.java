package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.as.vo.BookcaseVO;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/29 22:38
 */
public interface BookcaseLogic {
    /**
     * 添加书籍
     * @param bookId /
     * @param userId /
     */
    void add(Long bookId, Long userId);

    /**
     * 删除书籍
     * @param bookcaseId /
     * @param userId /
     */
    void delete(Long bookcaseId, Long userId);

    /**
     * 获取书箱记录
     * @param userId /
     * @return /
     */
    List<BookcaseVO> getListByUserId(Long userId);
}
