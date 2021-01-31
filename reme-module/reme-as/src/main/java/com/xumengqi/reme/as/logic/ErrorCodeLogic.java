package com.xumengqi.reme.as.logic;


import com.xumengqi.reme.dao.dto.ErrorCodeDTO;
import com.xumengqi.reme.dao.vo.ErrorCodeVO;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/1/30 22:48
 */
public interface ErrorCodeLogic {
    List<ErrorCodeVO> listForPage(ErrorCodeDTO errorCodeDTO);
}
