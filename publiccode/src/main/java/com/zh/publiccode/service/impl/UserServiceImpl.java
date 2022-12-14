package com.zh.publiccode.service.impl;

import com.zh.publiccode.common.CommonMethod;
import com.zh.publiccode.dao.UserMapper;
import com.zh.publiccode.entity.User;
import com.zh.publiccode.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;


import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate<String,User> redisTemplate;
    @Override
    public String loginUser(User user) {
        User user1 = new User();
        if (Objects.nonNull(user)){
            String userName = user.getUserName();
            String password = user.getPassword();
             user1 = userMapper.loginUser(userName, password);
          if (Objects.nonNull(user1)){
              return "登录成功";
          }
        }
        return "用户名或密码错误";
    }

    @Override
    public User getUserInfo(String id) {
        String userId = CommonMethod.getUserId(id);
        Boolean isKey = redisTemplate.hasKey(userId);
        if (isKey){
            User user = redisTemplate.opsForValue().get(userId);
//            redisTemplate.delete(userId);
            System.out.println("redis缓存获取user信息，user="+user);
            return user;
        }
        User userById = userMapper.getUserById(id);
        System.out.println("数据库获取user信息,user="+userById);
        redisTemplate.opsForValue().set(userId,userById,1, TimeUnit.HOURS);
        return userById;
    }





}
