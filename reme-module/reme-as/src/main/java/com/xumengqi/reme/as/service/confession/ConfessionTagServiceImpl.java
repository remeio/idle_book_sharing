package com.xumengqi.reme.as.service.confession;

import com.xumengqi.reme.api.confession.dto.ConfessionTagDTO;
import com.xumengqi.reme.api.confession.request.GetConfessionTagListRequest;
import com.xumengqi.reme.api.confession.response.GetConfessionTagListResponse;
import com.xumengqi.reme.api.confession.service.ConfessionTagService;
import com.xumengqi.reme.as.logic.confession.ConfessionTagLogic;
import com.xumengqi.reme.base.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/9 17:49
 */
@Component
public class ConfessionTagServiceImpl implements ConfessionTagService {
    @Autowired
    private ConfessionTagLogic confessionTagLogic;

    @Override
    public GetConfessionTagListResponse getConfessionTagList(GetConfessionTagListRequest request) {
        GetConfessionTagListResponse response = new GetConfessionTagListResponse();
        List<ConfessionTagDTO> confessionTagDTOList = ConvertUtils.toList(confessionTagLogic.getConfessionTagList(), ConfessionTagDTO.class);
        response.setConfessionTagList(confessionTagDTOList);
        return response;
    }
}
