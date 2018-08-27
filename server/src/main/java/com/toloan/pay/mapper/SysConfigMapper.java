package com.toloan.pay.mapper;

import com.toloan.pay.pojo.SysConfig;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    /**
     * 查询所有系统配置
     * @return
     */
    List<SysConfig> findAll();
}