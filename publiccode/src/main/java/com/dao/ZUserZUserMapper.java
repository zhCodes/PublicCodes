package com.dao;

import com.entity.ZUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date: 2023/4/11 14:34
 * @Author: Zhanghuihui
 * @Description: 
 */
@Mapper
public interface ZUserZUserMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ZUser record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ZUser record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ZUser selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ZUser record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ZUser record);
}