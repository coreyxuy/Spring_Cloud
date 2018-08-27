package com.toloan.pay.service.impl;

import com.toloan.pay.enums.Constant;
import com.toloan.pay.exception.SimpleMessageException;
import com.toloan.pay.mapper.SysConfigMapper;
import com.toloan.pay.pojo.SysConfig;
import com.toloan.pay.service.SysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* User:    mcwang
* DateTime:2016-08-04 03:26:22
* details: 系统参数表,Service实现层
* source:  代码生成器
*/
@Service(value = "sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
	/**
	 * 日志操作
	 */
    private static final Logger log = LoggerFactory.getLogger(SysConfigServiceImpl.class);
    /**
	 * 系统参数表dao层
	 */
    @Resource
    private SysConfigMapper sysConfigMapper;
	

	/**
	 * 系统参数表表,插入数据
	 * @param sysConfig 系统参数表类
	 * @return           返回页面map
	 * @throws SimpleMessageException
	 */
	public long insertSysConfig(SysConfig sysConfig) throws SimpleMessageException{
		try {
			return	sysConfigMapper.insertSelective(sysConfig);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new SimpleMessageException( Constant.FAIL_CODE_VALUE,e.getMessage());
		}
	}

	/**
	* 系统参数表表,修改数据
	* @param sysConfig 系统参数表类
	* @return           返回页面map
	* @throws SimpleMessageException
	*/
	public long updateSysConfig(SysConfig sysConfig) throws SimpleMessageException {
		try {
			return	sysConfigMapper.updateByPrimaryKeySelective(sysConfig);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new SimpleMessageException(Constant.FAIL_CODE_VALUE,e.getMessage());
		}
	}


	@Override
	public List<SysConfig> findAll() {
		return sysConfigMapper.findAll();
	}


}