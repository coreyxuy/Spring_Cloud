package com.toloan.pay.service;

import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.pay.pojo.SysConfig;

import java.util.List;
import java.util.Map;

/**
* User:    mcwang
* DateTime:2016-08-04 03:26:22
* details: 系统参数表,Service接口层
* source:  代码生成器
*/
public interface SysConfigService {

    /**
     * 系统参数表表,插入数据
     * @param sysConfig 系统参数表类
     * @return           返回页面map
     * @throws SimpleMessageException
     * @throws Exception
     */
    long insertSysConfig(SysConfig sysConfig) throws SimpleMessageException;

    /**
     * 系统参数表表,修改数据
     * @param sysConfig 系统参数表类
     * @return           返回页面map
     * @throws SimpleMessageException
     * @throws Exception
     */
  	long updateSysConfig(SysConfig sysConfig) throws SimpleMessageException;


   	 /**
   	  * 查询所有配置
   	  * @return
   	  * @throws Exception
   	  */
   	 List<SysConfig> findAll();


}
