package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/26 14:11
 */
@Getter
@Setter
public class GetBookInfoRequest extends BaseRequest {
    /**
     * 书籍ID
     */
    private Long bookId;
}
