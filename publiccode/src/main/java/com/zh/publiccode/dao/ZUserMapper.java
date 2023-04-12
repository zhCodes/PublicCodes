package com.zh.publiccode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.publiccode.entity.ZUser;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Date: 2023/4/11 14:34
 * @Author: Zhanghuihui
 * @Description: 
 */
@Mapper
public interface ZUserMapper extends BaseMapper<ZUser> {
    int insertBatchSomeColumn (List<ZUser> userList);

}