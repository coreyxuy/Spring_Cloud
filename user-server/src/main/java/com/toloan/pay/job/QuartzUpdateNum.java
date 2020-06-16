package com.toloan.pay.job;

import com.toloan.pay.mapper.ChannelLogMapper;
import com.toloan.pay.mapper.ChannelSwitchMapper;
import com.toloan.pay.pojo.ChannelLog;
import com.toloan.pay.pojo.ChannelSwitch;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class QuartzUpdateNum {

    @Resource
    private ChannelSwitchMapper channelSwitchMapper;

    @Resource
    private ChannelLogMapper channelLogMapper;

    @Scheduled(cron = "0 15 0 * * ? ")
    public void timerToNow(){
        // 开始执行定时任务，更新今日各个渠道数据
        // 查询出全部渠道
        List<ChannelSwitch> switches = channelSwitchMapper.getAllChannel();
        // 更新渠道每日注册数和点击数
        Integer registerTemp;               // 真实导入流量数据
        Integer registerNum;                // 计算完成注册数
        Integer authNum;                    // 实名认证数
        Integer borrowNum;                  // 申请借款数
        Integer loanNum;                    // 成功放款数

        // 比例
        Double authRate;                    // 实名认证比例
        Double borrowRate;                  // 申请比例
        Double loanRate;                    // 借款比例

        // 对象
        ChannelSwitch channelSwitch ;
        Random random = new Random();
        ChannelLog channelLog;
        for (int i = 0; i < switches.size(); i++){
            channelLog = new ChannelLog();
            channelSwitch = switches.get(i);
            registerTemp = channelLogMapper.getRegisterNum(channelSwitch.getChannelId());
            registerNum = (int)(registerTemp * channelSwitch.getRegisterRate());
            authRate = (random.nextDouble() * 0.1) + (channelSwitch.getAuthRate() - 0.1);
            authNum = (int)(registerNum * authRate);
            borrowRate = (random.nextDouble() * 0.1) + (channelSwitch.getBorrowRate() - 0.1);
            borrowNum = (int)(authNum * borrowRate);
            loanRate = (random.nextDouble() * 0.1 ) + (channelSwitch.getLoanRate() - 0.1);
            loanNum = (int)(loanRate * borrowNum);
            // 封装对象
            channelLog.setChannelId(channelSwitch.getChannelId());
            channelLog.setRegisterNum(registerNum);
            channelLog.setAuthNum(authNum);
            channelLog.setBorrowNum(borrowNum);
            channelLog.setLoanNum(loanNum);
            channelLog.setCreateTime(new Date());
            channelLogMapper.save(channelLog);
        }


    }

}
