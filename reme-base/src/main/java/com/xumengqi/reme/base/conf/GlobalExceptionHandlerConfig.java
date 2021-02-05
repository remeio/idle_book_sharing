package com.xumengqi.reme.base.conf;

import com.xumengqi.reme.base.BaseResponse;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Optional;

/**
 * 统一异常处理
 * @author xumengqi
 * @date 2020/12/31 17:27
 */
@ControllerAdvice
public class GlobalExceptionHandlerConfig {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandlerConfig.class);

    /**
     * 业务异常
     * @param req /
     * @param e /
     * @return 响应
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public BaseResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.info("BizException: " + e.getMessage(), e);
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
            baseResponse.error(ErrorCodeEnum.ILLEGAL_PARAMETER);
            return baseResponse;
        }
        log.info(String.format("BindException: %s with '%s'.'%s': [%s]",
                fieldError.getDefaultMessage(),
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

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public BaseResponse sqlExceptionHandler(HttpServletRequest req, SQLException e) {
        BaseResponse baseResponse = new BaseResponse();
        log.info("SQLException: " + e.getMessage(), e);
        baseResponse.error(ErrorCodeEnum.SQL_ERROR);
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
        log.warn("Exception: " + e.getMessage(), e);
        baseResponse.error(ErrorCodeEnum.SYSTEM_ERROR);
        return baseResponse;
    }
}
