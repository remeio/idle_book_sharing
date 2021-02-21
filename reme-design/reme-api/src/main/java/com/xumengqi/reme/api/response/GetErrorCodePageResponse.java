package com.xumengqi.reme.api.response;

import com.xumengqi.reme.base.PageResponse;
import com.xumengqi.reme.api.vo.ErrorCodeVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/1/30 22:29
 */
@Getter
@Setter
public class GetErrorCodePageResponse extends PageResponse {
    List<ErrorCodeVO> items;
}
