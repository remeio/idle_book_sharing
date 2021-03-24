package com.xumengqi.reme.as.logic.user.impl;

import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.School;
import com.xumengqi.reme.dao.entity.SchoolExample;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.entity.UserExample;
import com.xumengqi.reme.dao.mapper.SchoolMapper;
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

    @Autowired
    private SchoolMapper schoolMapper;

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

    @Override
    public void addUser(User user, String schoolName) {
        final String userPhone = user.getUserPhone();
        final String userPassword = user.getUserPassword();
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUserPhoneEqualTo(userPhone);
        // 判断用户是否已注册
        AssertUtils.asserter().assertEqualOne(userMapper.countByExample(userExample)).elseThrow(ErrorCodeEnum.THE_PHONE_NUMBER_HAS_BEEN_REGISTERED);
        // 判断学校是否存在
        SchoolExample schoolExample = new SchoolExample();
        schoolExample.createCriteria().andSchoolNameEqualTo(schoolName);
        School school = schoolMapper.selectByExample(schoolExample).stream().findFirst().orElse(null);
        AssertUtils.asserter().assertNotNull(school).elseThrow(ErrorCodeEnum.SCHOOL_NOT_EXIST);
        User record = new User();
        record.setUserPhone(userPhone);
        record.setUserPassword(userPassword);
        record.setUserFullName(user.getUserFullName());
        record.setSchoolId(school.getId());
        userMapper.insertSelective(record);
    }
}