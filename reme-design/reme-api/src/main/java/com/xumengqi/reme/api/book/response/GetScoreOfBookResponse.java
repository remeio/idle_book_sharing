package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/4/3 14:21
 */
@Getter
@Setter
public class GetScoreOfBookResponse extends BaseResponse {

    private Double score;
}
