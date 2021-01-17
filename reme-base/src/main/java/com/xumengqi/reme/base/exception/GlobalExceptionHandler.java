package com.xumengqi.reme.base.exception;

import com.xumengqi.reme.base.base.BaseResponse;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * 统一异常处理
 * @author xumengqi
 * @date 2020/12/31 17:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     * @param req /
     * @param e /
     * @return 响应
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("BizException: " + e.getMessage(), e);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorNo(e.getErrorNo());
        baseResponse.setErrorInfo(e.getErrorInfo());
        return baseResponse;
    }

    /**
     * 参数校验异常
     * @param req /
     * @param e /
     * @return 响应
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public BaseResponse bizExceptionHandler(HttpServletRequest req, BindException e) {
        final FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError == null) {
            log.error("BindException: " + e.getMessage(), e);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.failure(ErrorCodeEnum.ILLEGAL_PARAMETER);
            return baseResponse;
        }
        log.error(String.format("BindException: [Field error in object '%s' on field '%s': rejected value [%s]",
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue()));
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorNo(ErrorCodeEnum.ILLEGAL_PARAMETER.getCode());
        baseResponse.setErrorInfo(Optional.of(fieldError)
                .map(FieldError::getDefaultMessage)
                .orElse(ErrorCodeEnum.ILLEGAL_PARAMETER.getMessage()));
        return baseResponse;
    }

    /**
     * 通用异常
     * @param req /
     * @param e /
     * @return 响应
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest req, Exception e) {
        BaseResponse baseResponse = new BaseResponse();
        log.error("Exception: " + e.getMessage(), e);
        baseResponse.failure(ErrorCodeEnum.SYSTEM_ERROR);
        return baseResponse;
    }
}
