package com.toloan.pay.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.toloan.pay.mapper.ChannelLogMapper;
import com.toloan.pay.mapper.ChannelSwitchMapper;
import com.toloan.pay.pojo.ChannelLog;
import com.toloan.pay.pojo.ChannelSwitch;
import com.toloan.pay.service.ChannelLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ChannelLogImpl implements ChannelLogService {
    @Resource
    private ChannelLogMapper channelLogMapper;
    @Resource
    private ChannelSwitchMapper channelSwitchMapper;

    @Override
    public ChannelLog findTodayData(String channelId ) {
        ChannelLog todayLog = channelLogMapper.findToday(channelId);
        ChannelSwitch channelSwitch = channelSwitchMapper.findByChannel(channelId);
        Integer registerTemp = channelLogMapper.getRegisterNum(channelSwitch.getChannelId());
        Integer registerNum = (int)(registerTemp * channelSwitch.getRegisterRate());
        Random random = new Random();
        Double authRate = (random.nextDouble() * 0.1) + (channelSwitch.getAuthRate() - 0.1);
        Integer authNum = (int)(registerNum * authRate);
        Double borrowRate = (random.nextDouble() * 0.1) + (channelSwitch.getBorrowRate() - 0.1);
        Integer borrowNum = (int)(authNum * borrowRate);
        Double loanRate = (random.nextDouble() * 0.1) + (channelSwitch.getLoanRate() - 0.1);
        Integer loanNum = (int)(loanRate * borrowNum);
        if(todayLog == null){
            // 今天第一次打开，需要更新全部数据
            // 封装对象
            ChannelLog channelLog = new ChannelLog();
            channelLog.setChannelId(channelSwitch.getChannelId());
            channelLog.setRegisterNum(registerNum);
            channelLog.setAuthNum(authNum);
            channelLog.setBorrowNum(borrowNum);
            channelLog.setLoanNum(loanNum);
            channelLog.setCreateTime(new Date());
            channelLogMapper.save(channelLog);
            return channelLog;
        }else {
            // 今天第二次打开，需要判断是否需要更新数据
            Date now = new Date();
            int minutes = (int)(now.getTime() - todayLog.getUpdateTime().getTime()) / (1000 * 60);
            if(minutes <= 15){
                todayLog.setRegisterNum(registerNum);
                todayLog.setUpdateTime(now);
                channelLogMapper.update(todayLog);
            }
            todayLog.setRegisterNum(registerNum);
            Integer authReduce = authNum - todayLog.getAuthNum();
            Integer borrowReduce = borrowNum - todayLog.getBorrowNum();
            Integer loanReduce = loanNum - todayLog.getLoanNum();
            if(authReduce > 0){
                random = new Random(authReduce);
                todayLog.setAuthNum(todayLog.getAuthNum() + random.nextInt());
            }
            if(borrowReduce > 0){
                random = new Random(borrowReduce);
                todayLog.setBorrowNum(todayLog.getBorrowNum() + random.nextInt());
            }
            if(loanReduce > 0){
                random = new Random(loanReduce);
                todayLog.setLoanNum(todayLog.getLoanNum() + random.nextInt());
            }
            channelLogMapper.update(todayLog);
            return todayLog;
        }
    }


    @Override
    public Page<ChannelLog> findHistoryData(String channelId , int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ChannelLog> historyData = channelLogMapper.findHistoryData(channelId);
        return (Page<ChannelLog>) historyData;
    }
}
