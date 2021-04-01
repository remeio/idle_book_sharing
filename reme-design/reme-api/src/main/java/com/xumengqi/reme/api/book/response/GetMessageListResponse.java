package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.MessageDTO;
import com.xumengqi.reme.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/4/1 15:23
 */
@Getter
@Setter
public class GetMessageListResponse extends BaseResponse {
    private List<MessageDTO> messageDTOList;

    private String shareUserFullName;

    private String borrowUserFullName;
}
