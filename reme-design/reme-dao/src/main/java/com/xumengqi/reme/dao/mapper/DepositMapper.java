package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Deposit;
import com.xumengqi.reme.dao.entity.DepositExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepositMapper {
    long countByExample(DepositExample example);

    int deleteByExample(DepositExample example);

    int deleteByPrimaryKey(Long depositId);

    int insert(Deposit record);

    int insertSelective(Deposit record);

    List<Deposit> selectByExample(DepositExample example);

    Deposit selectByPrimaryKey(Long depositId);

    int updateByExampleSelective(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByExample(@Param("record") Deposit record, @Param("example") DepositExample example);

    int updateByPrimaryKeySelective(Deposit record);

    int updateByPrimaryKey(Deposit record);
}