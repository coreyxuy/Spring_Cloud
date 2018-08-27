package com.toloan.pay.service;

import com.toloan.pay.pojo.BorrowProgress;

/**
 * Created by ：Corey
 * 14:55 2018/8/20
 * 用户借款信息
 */
public interface BorrowProgressService {

    BorrowProgress getBorrowProgress(Long userId, String channelCode);

    /**
     * 修改用户状态
     * @param userId
     * @return
     */
    int updateBorrowStatus(Long userId);


    int updateBorrowSta(Long userId);

    /**
     * 首页显示借款状态
     * @param userId
     * @return
     */
    BorrowProgress getBorrowDetail(Long userId);


}
