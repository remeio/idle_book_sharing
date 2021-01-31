package com.xumengqi.reme.api.response;

import com.xumengqi.reme.base.PageResponse;
import com.xumengqi.reme.dao.vo.ErrorCodeVO;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/1/30 22:29
 */
public class GetErrorCodePageResponse extends PageResponse {
    List<ErrorCodeVO> items;

    public List<ErrorCodeVO> getItems() {
        return items;
    }

    public void setItems(List<ErrorCodeVO> items) {
        this.items = items;
    }
}
