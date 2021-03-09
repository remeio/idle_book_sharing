package com.xumengqi.reme.as.service.confession;

import com.xumengqi.reme.api.confession.request.PostConfessionRequest;
import com.xumengqi.reme.api.confession.response.PostConfessionResponse;
import com.xumengqi.reme.api.confession.service.ConfessionService;
import com.xumengqi.reme.as.logic.confession.ConfessionLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.dao.entity.Confession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/3/8 18:13
 */
@Component
public class ConfessionServiceImpl implements ConfessionService {
    @Autowired
    private ConfessionLogic confessionLogic;

    @AccessToken
    @Override
    public PostConfessionResponse postConfession(PostConfessionRequest request) {
        Confession confession = new Confession();
        confession.setConfessionTitle(request.getConfessionTitle());
        confession.setConfessionDetail(request.getConfessionDetail());
        confession.setIsAnonymous(request.getIsAnonymous());
        confession.setConfessionTagId(request.getConfessionTagId());
        confession.setConfessionLocation(request.getConfessionLocation());
        confession.setUserId(request.getOperatorId());
        confessionLogic.addConfession(confession, request.getAttachIds());
        return new PostConfessionResponse();
    }

}
