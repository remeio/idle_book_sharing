package com.xumengqi.reme.as.logic.user;

import com.xumengqi.reme.dao.entity.User;

/**
 * @author xumengqi
 * @date 2021/2/27 13:23
 */
public interface UserLogic {

    /**
     * 验证用户，并返回用户ID
     * @param userPhone /
     * @param userPassword /
     * @return 用户ID
     */
    Long validateUser(String userPhone, String userPassword);

}
