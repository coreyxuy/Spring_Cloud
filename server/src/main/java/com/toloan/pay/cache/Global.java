package com.toloan.pay.cache;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

/**
 * 启动加载缓存类
 *
 */
public class Global {

	public static Map<String, Object> configMap;

	public static Map<String, Object> msg_template_Map;

	public static int getInt(String key){
		Object o = configMap.get(key);
		if (StringUtils.isNumeric(o + StringUtils.EMPTY)){
			return Integer.valueOf(o + StringUtils.EMPTY);
		}else {
			return 0;
		}
	}

	public static double getDouble(String key){
		Object o = configMap.get(key);
		if (NumberUtils.isDigits(o + StringUtils.EMPTY)){
			return Double.valueOf(o + StringUtils.EMPTY);
		}else {
			return 0;
		}
	}

	public static String getValue(String key) {
		Object o = configMap.get(key);
		if(o != null){
			return o + StringUtils.EMPTY;
		}else {
			return StringUtils.EMPTY;
		}
	}

	public static Object getObject(String key){
		return configMap.get(key);
	}

	public static String getMsgTempLate(String key) {
		Object o = msg_template_Map.get(key);
		if(o != null){
			return o + StringUtils.EMPTY;
		}else {
			return StringUtils.EMPTY;
		}
	}

}
