package com.xumengqi.reme.as.mapper;

import com.xumengqi.reme.as.vo.RankVO;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 19:49
 */
public interface ShareRecordExtMapper {

    /**
     * 查询借阅者共享记录
     *
     * @param userId /
     * @return /
     */
    List<ShareRecordVO> selectByBorrowUserId(@Param("userId") Long userId);

    /**
     * 查询共享者共享记录
     *
     * @param userId /
     * @return /
     */
    List<ShareRecordVO> selectByShareUserId(@Param("userId") Long userId);

    /**
     * 查询共享记录
     *
     * @param id /
     * @return /
     */
    ShareRecordVO selectById(@Param("id") Long id);

    /**
     * 获取借阅排行榜
     *
     * @param count 数量
     * @return /
     */
    List<RankVO> getBorrowRankList(@Param("count") Integer count);


    /**
     * 获取共享排行榜
     *
     * @param count 数量
     * @return /
     */
    List<RankVO> getShareRankList(@Param("count") Integer count);
}
