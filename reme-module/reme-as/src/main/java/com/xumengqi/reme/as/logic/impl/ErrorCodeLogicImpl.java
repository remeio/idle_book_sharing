package com.xumengqi.reme.as.logic.impl;

import com.xumengqi.reme.as.logic.ErrorCodeLogic;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.api.dto.ErrorCodeDTO;
import com.xumengqi.reme.dao.entity.ErrorCode;
import com.xumengqi.reme.dao.entity.ErrorCodeExample;
import com.xumengqi.reme.dao.mapper.ErrorCodeMapper;
import com.xumengqi.reme.api.vo.ErrorCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author xumengqi
 * @date 2021/1/30 22:48
 */
@Component
public class ErrorCodeLogicImpl implements ErrorCodeLogic {
    @Autowired
    private ErrorCodeMapper errorCodeMapper;

    @Override
    public List<ErrorCodeVO> listForPage(ErrorCodeDTO errorCodeDTO) {
        ErrorCodeExample example = new ErrorCodeExample();
        ErrorCodeExample.Criteria criteria = example.createCriteria();
        Optional.ofNullable(errorCodeDTO)
                .map(ErrorCodeDTO::getCode)
                .ifPresent(criteria::andCodeEqualTo);
        Optional.ofNullable(errorCodeDTO)
                .map(ErrorCodeDTO::getMessage)
                .map(e -> "%" + e + "%")
                .ifPresent(criteria::andMessageLike);
        List<ErrorCode> errorCodeList = errorCodeMapper.selectByExample(example);
        return ConvertUtils.toList(errorCodeList, ErrorCodeVO.class);
    }
}
