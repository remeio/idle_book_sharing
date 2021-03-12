package com.xumengqi.reme.as.service.confession;

import com.github.pagehelper.PageHelper;
import com.xumengqi.reme.api.confession.dto.ConfessionDTO;
import com.xumengqi.reme.api.confession.request.GetConfessionPageBySchoolRequest;
import com.xumengqi.reme.api.confession.request.PostConfessionRequest;
import com.xumengqi.reme.api.confession.response.GetConfessionPageBySchoolResponse;
import com.xumengqi.reme.api.confession.response.PostConfessionResponse;
import com.xumengqi.reme.api.confession.service.ConfessionService;
import com.xumengqi.reme.as.logic.confession.ConfessionLogic;
import com.xumengqi.reme.as.logic.confession.FavorLogic;
import com.xumengqi.reme.as.vo.ConfessionVO;
import com.xumengqi.reme.as.vo.FavorVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.base.util.PageUtils;
import com.xumengqi.reme.dao.entity.Confession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/3/8 18:13
 */
@AccessToken
@Component
public class ConfessionServiceImpl implements ConfessionService {
    @Autowired
    private ConfessionLogic confessionLogic;

    @Autowired
    private FavorLogic favorLogic;

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

    @Override
    public GetConfessionPageBySchoolResponse getConfessionPageBySchool(GetConfessionPageBySchoolRequest request) {
        final Long schoolId = request.getSchoolId();
        final Set<Long> confessionTagIdSet = Optional.ofNullable(request.getConfessionTagIdSet()).orElse(new HashSet<>());
        final Integer isSolved = request.getIsSolved();
        final Long userId = request.getOperatorId();
        confessionLogic.checkListConfessionParameter(schoolId,null, confessionTagIdSet, isSolved);
        PageHelper.startPage(request.getPageNum(), request.getPageSize(), Optional.ofNullable(request.getOrderBy()).orElse("cc.gmt_create desc"));
        List<ConfessionVO> confessionList = confessionLogic.listConfessionBySchoolId(request.getSchoolId(), request.getConfessionTagIdSet(), request.getIsSolved());
        List<ConfessionDTO> confessionDTOList = ConvertUtils.toList(confessionList, ConfessionDTO.class);
        // 添加点赞数量
        List<FavorVO> favorVOList = favorLogic.mapFavorOfConfession(confessionList.stream().map(ConfessionVO::getConfessionId).collect(Collectors.toSet()), null);
        favorVOList.forEach(f -> {
            confessionDTOList.stream().filter(c -> c.getConfessionId().equals(f.getConfessionId())).forEach(cc -> {
                cc.setFavorCount(f.getFavorCount());
            });
        });
        // 添加是否已点赞
        favorVOList = favorLogic.mapFavorOfConfession(confessionList.stream().map(ConfessionVO::getConfessionId).collect(Collectors.toSet()), userId);
        favorVOList.forEach(f -> {
            confessionDTOList.stream().filter(c -> c.getConfessionId().equals(f.getConfessionId())).forEach(cc -> {
                cc.setIsHadFavor(f.getFavorCount() > 0);
            });
        });
        GetConfessionPageBySchoolResponse response = new GetConfessionPageBySchoolResponse();
        response.setConfessionDTOList(confessionDTOList);
        return response;
    }
}
