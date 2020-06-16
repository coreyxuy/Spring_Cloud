package com.toloan.pay.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 运营商认证基本信息表Dao
 *
 */
public interface OperatorTdBasicMapper {

    int deleteByUserId(@Param("userId") Long userId);

}
