package com.toloan.pay.controller;

import com.toloan.pay.utils.HttpClientUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by ：Corey
 * 17:29 2018/8/22
 *
 */
public class boChController {

    private static final String api = "http://api.tanzhishuju.com/api/gateway";
    //系统分配的ApiKey，请用自己的ApiKey进行替换
    private static final String apiKey ="0140224286552170";
    //系统分配的ApiSecret，请用自己的ApiSecret进行替换
    private static final String secret ="50RlCdYWkT7vbESrTNxSRNMTfKALLCmv";
    //探知api的版本,运营商报告提交
    private static final String version ="2.0.0";



    /*public static void main(String[] args) throws Exception{
        //接口名称
        String method = "api.multiplebonds.report";
        //报告版本号
        String reportVersion = "9.5.1";
        //手机号
        String mobile  = "18827064583";
        // 待查手机号的运营商密码，也就用来登录运营商官网查看通话详单的密码
        String mobilePasswd = "916563";
        // 待查手机机主的姓名
        String trueName = "徐勇平";
        // 待查手机机主的身份证号
        String idCard = "420921199407242811";
        //验签
        String sign  = "7c696fe17481b403e428067970283841b3ac5934";
        Map<String,Object> param = new HashMap<>();
        param.put("apiKey ",apiKey );
        param.put("version ",version);
        param.put("sign",sign );
        param.put("method",method);
        param.put("reportVersion",reportVersion);
        param.put("mobile",mobile);
        param.put("trueName",trueName);
        param.put("idCard",idCard);
        String s = HttpClientUtil.postForm(api, param);
        //base64解码
        byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(s.getBytes("utf-8"));
        System.out.println(new String(bytes));
        ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            GZIPInputStream ungzip = new GZIPInputStream(tInputStringStream);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (tInputStringStream != null){
                try{
                    tInputStringStream.close();
                }catch (Exception e){
                    //doN
                }
            }
            if (out != null){
                try{
                    out.close();
                }catch (Exception e){
                    //doN
                }

            }
        }
        byte[] bytes1 = out.toByteArray();
        String result = new String(bytes1);
        System.out.println(result);

    }*/


}
