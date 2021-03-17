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
import com.xumengqi.reme.as.logic.file.FileLogic;
import com.xumengqi.reme.as.vo.ConfessionVO;
import com.xumengqi.reme.as.vo.FavorVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.YesOrNoEnum;
import com.xumengqi.reme.dao.entity.Confession;
import com.xumengqi.reme.dao.entity.ConfessionAttach;
import com.xumengqi.reme.dao.entity.ConfessionAttachExample;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.mapper.ConfessionAttachMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/3/8 18:13
 */
@SystemLog
@AccessToken
@Component
public class ConfessionServiceImpl implements ConfessionService {
    @Autowired
    private ConfessionLogic confessionLogic;

    @Autowired
    private FavorLogic favorLogic;

    @Autowired
    private FileLogic fileLogic;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ConfessionAttachMapper confessionAttachMapper;

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
        final Set<Long> confessionTagIdSet = Optional.ofNullable(request.getConfessionTagIdSet()).orElse(new HashSet<>());
        final Integer isSolved = request.getIsSolved();
        final Long userId = request.getOperatorId();
        User user = userMapper.selectByPrimaryKey(userId);
        AssertUtils.asserter().assertNotNull(user).elseThrow(ErrorCodeEnum.USER_NOT_EXISTS);
        final Long schoolId = user.getSchoolId();
        confessionLogic.checkListConfessionParameter(schoolId, null, confessionTagIdSet, isSolved);
        PageHelper.startPage(request.getPageNum(), request.getPageSize(), Optional.ofNullable(request.getOrderBy()).orElse("cc.gmt_create desc"));
        List<ConfessionVO> confessionVOList = confessionLogic.listConfessionBySchoolId(schoolId, confessionTagIdSet, isSolved);
        if (confessionVOList.size() == 0) {
            return new GetConfessionPageBySchoolResponse();
        }
        // 对用户头像路径进行添加
        Map<Long, String> filePathMap = fileLogic.getFileFullPaths(confessionVOList.stream().map(ConfessionVO::getAvatarAttachId).collect(Collectors.toSet()));
        confessionVOList.forEach(e -> {
            e.setAvatarFullPath(filePathMap.get(e.getAvatarAttachId()));
        });
        Set<Long> confessionIdSet = confessionVOList.stream().map(ConfessionVO::getConfessionId).collect(Collectors.toSet());
        List<ConfessionDTO> confessionDTOList = ConvertUtils.toList(confessionVOList, ConfessionDTO.class);
        // 添加点赞数量
        List<FavorVO> favorVOList = favorLogic.mapFavorOfConfession(confessionIdSet, null);
        favorVOList.forEach(f -> {
            confessionDTOList.stream().filter(c -> c.getConfessionId().equals(f.getConfessionId())).forEach(cc -> {
                cc.setFavorCount(f.getFavorCount());
            });
        });
        // 添加是否已点赞
        favorVOList = favorLogic.mapFavorOfConfession(confessionIdSet, userId);
        favorVOList.forEach(f -> {
            confessionDTOList.stream().filter(c -> c.getConfessionId().equals(f.getConfessionId())).forEach(cc -> {
                cc.setIsHadFavor(f.getFavorCount() > 0);
            });
        });
        // 添加附件列表
        ConfessionAttachExample confessionAttachExample = new ConfessionAttachExample();
        confessionAttachExample.createCriteria()
                .andConfessionIdIn(new ArrayList<>(confessionIdSet));
        confessionAttachExample.setOrderByClause("attach_order");
        List<ConfessionAttach> confessionAttachList = confessionAttachMapper.selectByExample(confessionAttachExample);
        if (confessionAttachList.size() > 0) {
            Map<Long, String> attachMap = fileLogic.getFileFullPaths(confessionAttachList.stream().map(ConfessionAttach::getAttachId).collect(Collectors.toSet()));
            confessionIdSet.forEach(c -> {
                confessionDTOList.stream().filter(dto -> dto.getConfessionId().equals(c)).findFirst().ifPresent(d -> {
                    d.setAttachFullPathList(confessionAttachList.stream()
                            .filter(e -> e.getConfessionId().equals(c))
                            .map(ConfessionAttach::getAttachId)
                            .map(attachMap::get)
                            .collect(Collectors.toSet()));
                });
            });
        }
        // 对匿名用户进行过滤
        confessionDTOList.forEach(e -> {
            if (YesOrNoEnum.isNo(e.getIsAnonymous())) {
                return;
            }
            if (userId.equals(e.getUserId())) {
                return;
            }
            // 匿名且不是本人
            e.setUserId(null);
            e.setUserName(null);
            e.setAvatarFullPath(null);
        });
        GetConfessionPageBySchoolResponse response = new GetConfessionPageBySchoolResponse();
        response.setConfessionDTOList(confessionDTOList);
        return response;
    }
}
