package com.xumengqi.reme.as.service;

import com.github.pagehelper.PageInfo;
import com.xumengqi.reme.api.request.GetErrorCodePageRequest;
import com.xumengqi.reme.api.response.GetErrorCodePageResponse;
import com.xumengqi.reme.api.service.ErrorCodeService;
import com.xumengqi.reme.as.logic.ErrorCodeLogic;
import com.xumengqi.reme.base.aspect.LogAspect;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.base.util.PageUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.dto.ErrorCodeDTO;
import com.xumengqi.reme.dao.vo.ErrorCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/1/30 22:31
 */
@LogAspect
@Component
public class ErrorCodeServiceImpl implements ErrorCodeService {

    @Autowired
    private ErrorCodeLogic errorCodeLogic;

    @Override
    public GetErrorCodePageResponse getErrorCodePage(GetErrorCodePageRequest request) {
        PageInfo<ErrorCodeVO> pageInfo = new PageUtils<ErrorCodeDTO, ErrorCodeVO>()
                .page(ConvertUtils.toObj(request, PageUtils.PageParam.class),
                        ConvertUtils.toObj(request, ErrorCodeDTO.class),
                        errorCodeLogic::listForPage);
        GetErrorCodePageResponse response = ConvertUtils.toObj(pageInfo, GetErrorCodePageResponse.class);
        response.setItems(pageInfo.getList());
        return response;
    }

}
