package com.xumengqi.reme.as.mapper;

import com.xumengqi.reme.as.vo.DepositVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 19:49
 */
public interface DepositExtMapper {

    /**
     * 查询押金
     *
     * @param userId /
     * @return /
     */
    List<DepositVO> selectByUserId(@Param("userId") Long userId);
}
