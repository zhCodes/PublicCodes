package com.zh.publiccode.controller;

import com.zh.publiccode.config.Response;
import com.zh.publiccode.service.WebSpiderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuihui
 * @date 2023/9/19
 * @description
 */
@Api(tags = "爬虫接口")
@RestController
@RequestMapping("/webSpider")
public class WebSpiderController {


    @Resource
    private WebSpiderService webSpiderService;

    /**
     * 爬取代理ip并入库
     * @return
     */
    @GetMapping("/getFreeProxyIp")
    public Response getFreeProxyIp() {
        webSpiderService.crawlIp();
        return Response.success("crawl success");
    }
}
