package com.toloan.pay.controller;

import com.github.pagehelper.Page;
import com.toloan.pay.pojo.ChannelLog;
import com.toloan.pay.pojo.ChannelSwitch;
import com.toloan.pay.pojo.ChannelUser;
import com.toloan.pay.pojo.SystemUser;
import com.toloan.pay.service.ChannelLogService;
import com.toloan.pay.service.ChannelSwitchService;
import com.toloan.pay.service.ChannelUserService;
import com.toloan.pay.service.SystemUserService;
import com.toloan.pay.utils.JsonUtil;
import com.toloan.pay.utils.RdPage;
import com.toloan.response.ResponseCode;
import com.toloan.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/system")
@Slf4j
public class ManageController {
    @Resource
    private ChannelLogService channelLogService;
    @Autowired
    private ChannelUserService channelUserService;
    @Autowired
    private SystemUserService systemUserService;
    @Resource
    private ChannelSwitchService channelSwitchService;



    /**
     * 普通商户登录
     *
     * @param username
     * @param password
     * @param accessCode
     * @param response
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping(value = "api/user/login.htm")
    public ServerResponse login(@RequestParam(value = "username", required = true) String username,
                                @RequestParam(value = "password", required = true) String password,
                                @RequestParam(value = "accessCode", required = false) String accessCode,
                                HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        // 登陆后需要将用户放到session域中
        ChannelUser channelUser = channelUserService.getChannelUser(username);
        if (channelUser == null) {
            return ServerResponse.createByErrorMessage("用戶名无效!");
        }
        if (!channelUser.getPassword().equalsIgnoreCase(password)) {
           return ServerResponse.createByErrorMessage("用户密码错误!");
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",channelUser.getId());
        map.put("name",username);
        session.setMaxInactiveInterval(60*10);
        session.setAttribute("channelUser",username);
        return ServerResponse.createBySuccess(map);
    }



    /**
     * 获取全部渠道信息
     * @return
     */
    @PostMapping(value = "api/system/updatePassword.htm")
    public ServerResponse updatePassword(@RequestParam(value = "userId") Long userId,
                                         @RequestParam(value = "password") String password){
        Map<String,Object> map = new HashMap<String,Object> ();
        map.put("userId",userId);
        map.put("password",password);
        int i = channelUserService.updatePassword(map);
        if (i == 1) {
            return  ServerResponse.createBySuccess("修改成功!");
        }
        return  ServerResponse.createByErrorMessage("修改失败,请联系管理员!");
    }





    /**
     * 管理员登录
     * @param username
     * @param password
     * @param accessCode
     * @param response
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/api/user/system.htm")
    public ServerResponse Systemlogin(@RequestParam(value = "username") String username,
                                      @RequestParam(value = "password") String password,
                                      @RequestParam(value = "accessCode", required = false) String accessCode,
                                      HttpServletResponse response, HttpServletRequest request, HttpSession session) throws Exception {
        // 登陆后需要将用户放到session域中
        Map<String, Object> map = new HashMap<String, Object>();
        SystemUser systemUser = systemUserService.getSystemUser(username);
        if (systemUser == null) {
            return ServerResponse.createByErrorMessage("用戶名无效!");
        }
        if (!systemUser.getPassword().equalsIgnoreCase(password)) {
            return ServerResponse.createByErrorMessage("用户密码错误!");
        }
        ChannelUser channelUser = new ChannelUser();
        channelUser.setName(username);
        session.setMaxInactiveInterval(60*10);
        session.setAttribute("channelUser",channelUser);
        request.getSession().setAttribute("channelUser", systemUser);
        return ServerResponse.createBySuccess(channelUser);
    }




    /**
     * 获取全部渠道信息
     * @return
     */
    @PostMapping(value = "api/system/findSwitchs.htm")
    public ServerResponse findSwitchs(@RequestParam(value = "channelName", required = false) String channelName,
                                      @RequestParam(value = "current") int current,
                                      @RequestParam(value = "pageSize") int pageSize){
        Page<ChannelSwitch> switches = channelSwitchService.getChannelSwitchs(current,pageSize,channelName);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("page",new RdPage(switches));
        result.put("switches", switches);
        return ServerResponse.createBySuccess(result);
    }


    /**
     * 首页展示
     * @param request
     * @return
     */
    @PostMapping(value = "/api/channel/finData.htm")
    public ServerResponse finData(HttpServletRequest request ,
                                  @RequestParam(value = "current") int current,
                                  @RequestParam(value = "pageSize") int pageSize) throws  Exception{
        String channelId = (String) request.getSession().getAttribute("channelUser");
        if (channelId == null){
            return  ServerResponse.createByErrorCodeMessage(ResponseCode.SESSION_EXIT.getCode(),ResponseCode.SESSION_EXIT.getDesc());
        }
//        String channelId = user.getName();
        ChannelLog today = channelLogService.findTodayData(channelId);
        //新增分页
        Page<ChannelLog> history = channelLogService.findHistoryData(channelId ,current, pageSize);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("today",today);
        result.put("page",new RdPage(history));
        result.put("history", history);
        return ServerResponse.createBySuccess(result);
    }


    /**
     * 插入渠道信息
     * @return
     */
    @PostMapping(value = "/api/system/insertSwitchs.htm")
    public ServerResponse insertSwitchs(@RequestBody ChannelSwitch switchs) {
        //判断渠道号是否相同
        String channelId  = channelSwitchService.getChannalName(switchs.getChannelId());
        if (channelId != null) {
            return  ServerResponse.createByErrorMessage("渠道号已存在!");
         }
            String pwd = channelSwitchService.insert(switchs);
            if (pwd == null) {
                return ServerResponse.createBySuccessMessage("插入失败，请稍后重试");
            }
            return ServerResponse.createBySuccess("添加成功");
        }


    /**
     * 编辑渠道信息
     * @return
     */
    @PostMapping(value = "/api/system/modifySwitchs.htm")
    public ServerResponse modifySwitchs(@RequestParam(value = "id") Long id,
                                        @RequestParam(value = "channelId") String channelId,
                                        @RequestParam(value = "borrowRate") Double borrowRate,
                                        @RequestParam(value = "switchs") String switchs,
                                        @RequestParam(value = "channelName") String channelName,
                                        @RequestParam(value = "registerRate") Double registerRate,
                                        @RequestParam(value = "authRate") Double authRate,
                                        @RequestParam(value = "loanRate") Double loanRate) {
        ChannelSwitch channelSwitch = new ChannelSwitch();
        channelSwitch.setId(id);
        channelSwitch.setChannelId(channelId);
        channelSwitch.setSwitchs(switchs);
        channelSwitch.setChannelName(channelName);
        channelSwitch.setRegisterRate(registerRate);
        channelSwitch.setBorrowRate(borrowRate);
        channelSwitch.setAuthRate(authRate);
        channelSwitch.setLoanRate(loanRate);
        int cha = channelSwitchService.updateSwitchs(channelSwitch);
        if (cha == 1) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("修改信息失败,请稍后再试");
    }




    /**
     * 删除
     * @return
     */
    @PostMapping(value = "/api/system/delSwitchs.htm")
    public ServerResponse removeSwitchs(@RequestParam(value = "channelId") String channelId){
        try {
            String pwd = channelSwitchService.removeSwitchs(channelId);
            if(pwd == null){
                return ServerResponse.createBySuccessMessage("插入失败，请稍后重试");
            }
            return ServerResponse.createBySuccess(pwd);
        }catch (Exception e){
            return ServerResponse.createBySuccessMessage("插入失败，请稍后重试");
        }
    }


}
