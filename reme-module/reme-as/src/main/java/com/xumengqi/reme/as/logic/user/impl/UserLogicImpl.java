package com.xumengqi.reme.as.logic.user.impl;

import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.entity.UserExample;
import com.xumengqi.reme.dao.mapper.SchoolMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 * @author xumengqi
 * @date 2021/2/27 13:23
 */
@Component
public class UserLogicImpl implements UserLogic {
    @Autowired
    private RedisUtils<String> redisUtils;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public void addUser(User user, String verificationCode) {
        final String userPhone = user.getUserPhone();
        final String userPassword = user.getUserPassword();
        final Long schoolId = user.getSchoolId();
        AssertUtils.isTrue(verificationCode.equals(redisUtils.get("signUp:" + userPhone)), ErrorCodeEnum.SQL_ERROR);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone);
        AssertUtils.isEqualZero(userMapper.countByExample(userExample), ErrorCodeEnum.SQL_ERROR);
        AssertUtils.isNotNull(schoolMapper.selectByPrimaryKey(schoolId), ErrorCodeEnum.SQL_ERROR);
        User record = new User();
        record.setUserPhone(userPhone);
        record.setUserPassword(userPassword);
        record.setSchoolId(schoolId);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        userMapper.insertSelective(record);
    }

    @Override
    public Long validateUser(String userPhone, String userPassword) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone)
                .andUserPasswordEqualTo(userPassword);
        User user = userMapper.selectByExample(userExample).stream().findFirst().orElse(null);
        AssertUtils.isNotNull(user, ErrorCodeEnum.SQL_ERROR);
        return user.getUserId();
    }
}
