package com.toloan.pay.mapper;

import com.toloan.pay.pojo.BorrowProgress;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ：Corey
 * 20:45 2018/8/20
 */
public interface BorrowProgressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BorrowProgress record);

    int insertSelective(BorrowProgress record);

    BorrowProgress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BorrowProgress record);

    int updateByPrimaryKey(BorrowProgress record);

    /**
     * 判断用户是否存在
     * @param userId
     * @param channelCode
     * @return
     */
    BorrowProgress getBorrowProgress(@Param("userId")Long userId, @Param("channelCode")String channelCode);


    int updateBorrowStatus(Long userId);

    BorrowProgress getBorrowDetail(Long userId);

    int getBorrowStal(Long userId);
}
