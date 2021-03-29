package com.xumengqi.reme.as.mapper;

import com.xumengqi.reme.as.vo.BookcaseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 19:49
 */
public interface BookcaseExtMapper {

    /**
     * 查询书箱记录
     *
     * @param userId /
     * @return /
     */
    List<BookcaseVO> selectByUserId(@Param("userId") Long userId);
}
