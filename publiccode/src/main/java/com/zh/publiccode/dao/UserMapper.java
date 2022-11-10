package com.zh.publiccode.dao;

import com.zh.publiccode.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User loginUser(@Param("userName") String userName, @Param("password") String password);

    User getUserById(@Param("id") String id);

}
