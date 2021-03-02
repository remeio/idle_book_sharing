package com.xumengqi.reme.as.logic.user.impl;

import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.entity.UserExample;
import com.xumengqi.reme.dao.mapper.SchoolMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        String verificationCodeInCache = redisUtils.get(RedisKeyPrefixEnum.SIGN_UP_VERIFICATION_CODE.getPrefix() + userPhone);
        // 判断验证码是否正确
        AssertUtils.isTrue(verificationCode.equals(verificationCodeInCache), ErrorCodeEnum.VERIFICATION_CODE_ERROR_OR_EXPIRED);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone);
        // 判断用户是否已注册
        AssertUtils.isEqualZero(userMapper.countByExample(userExample), ErrorCodeEnum.THE_PHONE_NUMBER_HAS_BEEN_REGISTERED);
        // 判断学校是否存在
        AssertUtils.isNotNull(schoolMapper.selectByPrimaryKey(schoolId), ErrorCodeEnum.SCHOOL_NOT_EXIST);
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
        // 判断用户是否存在
        AssertUtils.isNotNull(user, ErrorCodeEnum.WRONG_PASSWORD);
        return user.getUserId();
    }

    @Override
    public void resetPassword(String userPhone, String newPassword) {
        // 判断用户是否存在
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone);
        User record = userMapper.selectByExample(userExample).stream().findFirst().orElse(null);
        AssertUtils.isNotNull(record, ErrorCodeEnum.USER_NOT_EXISTS);
        // 修改密码
        Long recordId = record.getUserId();
        User newRecord = new User();
        newRecord.setUserId(recordId);
        newRecord.setUserPassword(newPassword);
        userMapper.updateByPrimaryKeySelective(newRecord);
    }


}
