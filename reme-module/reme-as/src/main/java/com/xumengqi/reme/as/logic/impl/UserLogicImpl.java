package com.xumengqi.reme.as.logic.impl;

import com.xumengqi.reme.as.logic.UserLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.UserExample;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/8 09:47
 */
@Component
public class UserLogicImpl implements UserLogic {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void isValidUser(String username, String password) {
        // 判断是否是正确的用户名和密码
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        long count = userMapper.countByExample(userExample);
        AssertUtils.isEqualOne(count, ErrorCodeEnum.INCORRECT_USERNAME_OR_PASSWORD);
    }
}
