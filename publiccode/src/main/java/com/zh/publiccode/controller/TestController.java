package com.zh.publiccode.controller;

import com.zh.publiccode.entity.User;
import com.zh.publiccode.service.TestIocService;
import com.zh.publiccode.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "用户校验接口",tags = "用户")
@RestController
@RequestMapping("/test/")
public class TestController {
    static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    @Resource
    private UserServiceImpl userService;

    @ApiOperation(value = "用户登录", notes = "用户登录",httpMethod = "POST")
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getInfo(@RequestBody User user){
        String login = userService.loginUser(user);

        return login;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public User getUserInfo(@RequestParam String id){
        User userInfo = userService.getUserInfo(id);

        return userInfo;
    }

}
