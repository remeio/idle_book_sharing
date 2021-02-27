package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Reply;
import com.xumengqi.reme.dao.entity.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {
    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Long replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Long replyId);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}