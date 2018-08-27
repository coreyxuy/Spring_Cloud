package com.toloan.pay.service.impl;

import com.toloan.pay.mapper.BorrowProgressMapper;
import com.toloan.pay.pojo.BorrowProgress;
import com.toloan.pay.service.BorrowProgressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ：Corey
 * 14:56 2018/8/20
 * 用户借款信息实现类
 */
@Service(value = "BorrowProgressService")
@Slf4j
public class BorrowProgressServiceImpl implements BorrowProgressService {

    @Autowired
    private BorrowProgressMapper borrowProgressMapper;

    @Override
    public BorrowProgress getBorrowProgress(Long userId, String channelCode) {
        return  borrowProgressMapper.getBorrowProgress(userId,channelCode);
    }

    /**
     * 修改用户状态
     * @param userId
     * @return
     */
    @Override
    public int updateBorrowStatus(Long userId) {
        return  borrowProgressMapper.updateBorrowStatus(userId);
    }



    /**
     * 用户借款状态
     * @param userId
     * @return
     */
    @Override
    public BorrowProgress getBorrowDetail(Long userId) {
        return borrowProgressMapper.getBorrowDetail(userId);
    }


    @Override
    public int updateBorrowSta(Long userId) {
        return borrowProgressMapper.getBorrowStal(userId);
    }
}
