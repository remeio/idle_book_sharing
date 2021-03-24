package com.xumengqi.reme.as.logic.user.impl;

import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.entity.UserExample;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 13:23
 */
@Component
public class UserLogicImpl implements UserLogic {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long validateUser(String userPhone, String userPassword) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone)
                .andUserPasswordEqualTo(userPassword);
        User user = userMapper.selectByExample(userExample).stream().findFirst().orElse(null);
        // 判断用户是否存在
        AssertUtils.asserter().assertNotNull(user).elseThrow(ErrorCodeEnum.WRONG_PASSWORD);
        return user.getId();
    }
}
