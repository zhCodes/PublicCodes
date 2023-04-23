package com.zh.code.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date: 2023/4/11 16:35
 * @Author: Zhanghuihui
 * @Description:
 */
@Controller
public class TestController {
    @GetMapping("index")
    @ApiOperation(value = "测试返回")
    public String index() {
        return "index";
    }
    @GetMapping("easyExcel")
    @ApiOperation(value = "easyExcel")
    public String easyExcel() {
        return "easyExcel";
    }
}
