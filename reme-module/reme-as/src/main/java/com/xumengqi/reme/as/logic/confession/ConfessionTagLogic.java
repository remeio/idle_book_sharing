package com.xumengqi.reme.as.logic.confession;

import com.xumengqi.reme.api.confession.service.ConfessionTagService;
import com.xumengqi.reme.dao.entity.ConfessionTag;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/9 17:49
 */
public interface ConfessionTagLogic {

    /**
     * 获取表白标签列表
     * @return /
     */
    List<ConfessionTag> getConfessionTagList();
}
