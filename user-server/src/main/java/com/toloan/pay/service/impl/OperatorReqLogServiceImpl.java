package com.toloan.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.toloan.pay.cache.Global;
import com.toloan.pay.mapper.*;
import com.toloan.pay.pojo.*;
import com.toloan.pay.service.OperatorReqLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "operatorReqLogService")
@Slf4j
public class OperatorReqLogServiceImpl implements OperatorReqLogService {

    @Resource
    private OperatorReqLogMapper operatorReqLogMapper;

    @Resource
    private OperatorTdBasicMapper operatorTdBasicMapper;

    @Resource
    private CellBehaviorMapper cellBehaviorMapper;

    @Resource
    private MxBasicMapper mxBasicMapper;

    @Resource
    private MxCellBehaviorCheckMapper mxCellBehaviorCheckMapper;

    @Resource
    private MxCallRecordMapper mxCallRecordMapper;



    @Override
    public int insert(OperatorReqLog operatorReqLog) {
        return operatorReqLogMapper.save(operatorReqLog);
    }

    @Override
    public OperatorReqLog findSelective(String orderNo) {
        return operatorReqLogMapper.findSelective(orderNo);
    }

    @Override
    public void saveMXOperatorInfos(JSONObject object, Long userId, OperatorReqLog reqLog) {
        log.info("===开始解析运营商数据====userId:"+userId);
        operatorTdBasicMapper.deleteByUserId(userId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (object != null) {
            List<Map<String, String>> cellPhone = (List) object.get("cell_phone");
            List<Map<String, String>> report = (List) object.get("report");
            List<Map<String, String>> basicCheckItems = (List) object.get("basic_check_items");
            List<Map<String, String>> behaviorCheck = (List) object.get("behavior_check");
            List<Map<String, JSONObject>> userInfoCheck = (List) object.get("user_info_check");
            List<Map<String, Object>> callContactDetail = (List) object.get("call_contact_detail");
            List<Map<String, List<JSONObject>>> cellBehavior = (List) object.get("cell_behavior");


            /**
             * 用户行为分析（按月汇总
             */

            Map<String, List<JSONObject>> cellBehaviorMap = cellBehavior.get(0);

            List<JSONObject> cellBehaviorObj = cellBehaviorMap.get("behavior");//通话记录完整性
            if (cellBehaviorObj != null) {
                for (JSONObject checkPoints : cellBehaviorObj) {
                    String smsCnt = checkPoints.get("sms_cnt") + "";//短信次数
                    String netFlow = checkPoints.get("net_flow") + "";//流量使用
                    String totalAmount = checkPoints.get("total_amount") + "";//消费金额
                    String cellMth = checkPoints.get("cell_mth") + "";//月份
                    String cellLoc = checkPoints.get("cell_loc") + "";//归属地
                    String cellOperatorZh = checkPoints.get("cell_operator_zh") + "";//运营商
                    String callCnt = checkPoints.get("call_cnt") + "";//通话次数
                    String callTime = checkPoints.get("call_time") + "";//通话时长
                    String dialedCnt = checkPoints.get("dialed_cnt") + "";//被叫次数
                    String dialedTime = checkPoints.get("dialed_time") + "";//被叫时长
                    String rechangeCnt = checkPoints.get("rechange_cnt") + "";//充值次数
                    String rechangeAmount = checkPoints.get("rechange_amount") + "";//充值总额
                    CellBehavior cellBehaviorMOdel = new CellBehavior();
                    cellBehaviorMOdel.setUserId(userId);
                    cellBehaviorMOdel.setOrderNo(reqLog.getOrderNo());
                    cellBehaviorMOdel.setReqLogId(reqLog.getId());
                    cellBehaviorMOdel.setSmscnt(smsCnt);
                    cellBehaviorMOdel.setNetflow(netFlow);
                    cellBehaviorMOdel.setTotalamount(totalAmount);
                    cellBehaviorMOdel.setCellmth(cellMth);
                    cellBehaviorMOdel.setCellloc(cellLoc);
                    cellBehaviorMOdel.setCelloperatorZh(cellOperatorZh);
                    cellBehaviorMOdel.setCallcnt(callCnt);
                    cellBehaviorMOdel.setCallcnt(callTime);
                    cellBehaviorMOdel.setDialcnt(dialedCnt);
                    cellBehaviorMOdel.setDialedtime(dialedTime);
                    cellBehaviorMOdel.setRechangeCnt(rechangeCnt);
                    cellBehaviorMOdel.setRechangeamount(rechangeAmount);
                    cellBehaviorMapper.save(cellBehaviorMOdel);

                }
            }
            if (cellPhone != null && cellPhone.size() > 10 && report != null && report.size() > 6 && basicCheckItems != null && basicCheckItems.size() > 9 && userInfoCheck.size() > 0 && userInfoCheck != null)  {


                Map<String, String> sourceNameZHMap = report.get(2);
                String sourceNameZH = sourceNameZHMap.get("value");//渠道数据源  中国移动中国联通中国电信
                Map<String, String> taskIdMap = report.get(4);
                String taskId = taskIdMap.get("value");//渠道数据源  中国移动中国联通中国电信
                Map<String, String> updateTimeMap = report.get(5);
                String updateTime = updateTimeMap.get("value");//报报告生成时间  2017-10-24 14:25:02

                Map<String, String> mobileMap = cellPhone.get(0);
                String mobile = mobileMap.get("value");//17600208817
                Map<String, String> carrierNameMap = cellPhone.get(1);
                String carrierName = carrierNameMap.get("value");//丁力士
                Map<String, String> regTimeMap = cellPhone.get(3);
                String regTime = regTimeMap.get("value");//入网时间
                Map<String, String> inTimeMap = cellPhone.get(4);
                String inTime = inTimeMap.get("value");//入网时长
                Map<String, String> reliabilityMap = cellPhone.get(7);
                String reliability = reliabilityMap.get("value");//实名认证
                Map<String, String> phoneAttributionMap = cellPhone.get(8);
                String phoneAttribution = phoneAttributionMap.get("value");//手机归属地
                Map<String, String> liveAddressMap = cellPhone.get(9);
                String liveAddress = liveAddressMap.get("value");//居住地址
                Map<String, String> callDataCheckMap = basicCheckItems.get(3);
                String callDataCheck = callDataCheckMap.get("result");//通话记录完整性
                Map<String, String> nameMatchMap = basicCheckItems.get(5);
                String nameMatch = callDataCheckMap.get("result");//姓名是否与运营商数据匹配
                Map<String, String> isNameAndIdcardInCourtBlackMap = basicCheckItems.get(6);
                String isNameAndIdcardInCourtBlack = isNameAndIdcardInCourtBlackMap.get("result");//身份证号码是否与运营商数据匹配
                Map<String, String> isNameAndIdcardInFinanceBlackMap = basicCheckItems.get(7);
                String isNameAndIdcardInFinanceBlack = isNameAndIdcardInFinanceBlackMap.get("result");//申请人姓名+身份证号码是否出现在法院黑名单
                Map<String, String> isNameAndMobileInFinanceBlackMap = basicCheckItems.get(8);
                String isNameAndMobileInFinanceBlack = isNameAndMobileInFinanceBlackMap.get("result");//申请人姓名+身份证号码是否出现在金融机构黑名单
                /**
                 *用户号码联系黑中介分数（分数范围0-100，参考分为10，分数越低关系越紧密）
                 */
                Map<String, JSONObject> userInfoCheckMap = userInfoCheck.get(0);
                JSONObject checkBlackInfo = userInfoCheckMap.get("check_black_info");
                Integer phoneGrayScore = (Integer) checkBlackInfo.get("phone_gray_score");
                MxBasic mb = new MxBasic();
                mb.setCalldatacheck(callDataCheck);
                mb.setCarriername(carrierName);
                HashMap<String, Object> params = new HashMap<String, Object>();
                params.put("userId", userId);
                if(inTime.equals("运营商未提供入网时间")){
                    inTime="0";
                }
                mb.setIntime(Long.parseLong(inTime));
                mb.setIsnameandidcardinfinanceblack(isNameAndIdcardInFinanceBlack);
                mb.setIsnameandmobileinfinanceblack(isNameAndMobileInFinanceBlack);
                mb.setMobile(mobile);
                mb.setNamematch(nameMatch);
                mb.setOrderNo(reqLog.getOrderNo());
                mb.setPhoneattribution(phoneAttribution);
                mb.setPhonegrayscore(phoneGrayScore.longValue());
                mb.setRegtime(regTime);
                mb.setReliability(reliability);
                mb.setReqLogId(reqLog.getId());
                mb.setSourcenamezh(sourceNameZH);
                mb.setTaskId(taskId);
                mb.setUpdatetime(updateTime);
                mb.setUserId(userId);
                mxBasicMapper.save(mb);
            }

            /**
             * 用户信息检测
             */
            if(behaviorCheck != null &&behaviorCheck.size() >= 27 ){
                Map<String, String> phoneUsedTimeMap = behaviorCheck.get(1);
                String phoneUsedTime = phoneUsedTimeMap.get("result");//号码使用时间
                Map<String, String> contactEachOtherMap = behaviorCheck.get(4);
                String contactEachOther = contactEachOtherMap.get("result");// 互通过电话的号码数量
                Map<String, String> contactCourtMap = behaviorCheck.get(9);
                String contactCourt = contactCourtMap.get("result");// 与法院电话通话情况
                Map<String, String> contactCollectionMap = behaviorCheck.get(13);
                String contactCollection = contactCollectionMap.get("result");//与催收类号码联系情况
                Map<String, String> phoneCallMap = behaviorCheck.get(26);
                String phoneCall = phoneCallMap.get("result");//号码通话情况（phone_call）
                MxCellBehaviorCheck mcbc = new MxCellBehaviorCheck();
                mcbc.setContactcollection(contactCollection);
                mcbc.setPhonecall(phoneCall);
                mcbc.setContactcourt(contactCourt);
                mcbc.setOrderNo(reqLog.getOrderNo());
                mcbc.setContacteachother(contactEachOther);
                mcbc.setPhoneusedtime(phoneUsedTime);
                mcbc.setReqLogId(reqLog.getId());
                mcbc.setUserId(userId);
                mxCellBehaviorCheckMapper.save(mcbc);
            }

            /**
             * 通话记录
             */
            if(callContactDetail != null ){
                for (Map<String, Object> callContactDetailMap : callContactDetail) {
                    String localCity = callContactDetailMap.get("city")+"";//归属地
                    String peerNum = callContactDetailMap.get("peer_num")+"";//号码
                    String groupName = callContactDetailMap.get("group_name")+"";//需求类型
                    String companyName = callContactDetailMap.get("company_name")+"";//互联网标识
                    String transEnd = callContactDetailMap.get("trans_end")+"";//最后一次通话时间
                    Integer callCnt6m =(Integer)callContactDetailMap.get("call_cnt_6m");//近六个月通话次数
                    MxCallRecord mcr = new MxCallRecord();
                    mcr.setUserId(userId);
                    mcr.setTransend(transEnd);
                    mcr.setPeernum(peerNum);
                    mcr.setGroupname(groupName);
                    mcr.setCompanyname(companyName);
                    mcr.setCallcnt6m(callCnt6m);
                    mcr.setCity(localCity);
                    mxCallRecordMapper.save(mcr);
                }
            }

        }
    }

    static final String CHASET_UTF_8 = "UTF-8";

    @Override
    public JSONObject mxOperatorQuery(Map<String, String> map) throws IOException {
        String operatorMoxieToken = Global.getValue("operator_moxie_token");
        CloseableHttpClient client = HttpClients.createDefault();
        String mobiles =map.get("mobiles");
        String taskId =map.get("taskId");

        String url= null;

        url  ="https://api.51datakey.com/carrier/v3/mobiles/"+mobiles+"/mxreport?task_id="+taskId;

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Authorization","token "+operatorMoxieToken);
        HttpResponse resp = client.execute(httpGet);
        HttpEntity he = resp.getEntity();
        String respContent = EntityUtils.toString(he, CHASET_UTF_8);
        JSONObject object =(JSONObject) JSONObject.parse(respContent);
        return object;
    }
}
