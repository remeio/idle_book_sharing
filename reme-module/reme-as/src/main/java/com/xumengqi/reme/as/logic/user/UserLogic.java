package com.xumengqi.reme.as.logic.user;

import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.entity.UserExample;

/**
 * @author xumengqi
 * @date 2021/2/27 13:23
 */
public interface UserLogic {
    /**
     * 新增用户
     * @param user /
     * @param verificationCode /
     */
    void addUser(User user, String verificationCode);


    /**
     * 验证用户，并返回用户ID
     * @param userPhone /
     * @param userPassword /
     * @return 用户ID
     */
    Long validateUser(String userPhone, String userPassword);


    /**
     * 重置密码
     * @param userPhone /
     * @param verificationCode /
     * @param newPassword /
     */
    void resetPassword(String userPhone, String newPassword);
}
