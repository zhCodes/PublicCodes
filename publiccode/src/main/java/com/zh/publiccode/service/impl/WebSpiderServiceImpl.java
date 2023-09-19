package com.zh.publiccode.service.impl;

import com.zh.publiccode.entity.SpiderProxyIpInfo;
import com.zh.publiccode.service.SpiderProxyIpInfoService;
import com.zh.publiccode.service.WebSpiderService;
import com.zh.publiccode.webspider.CrawlIpHandle;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/18
 * @description
 */
@Service
public class WebSpiderServiceImpl implements WebSpiderService {

    @Value("#{'${free-ip-address}'.split(',')}")
    private List<String> targetIpList;

    @Resource
    private SpiderProxyIpInfoService service;
    @Resource
    private CrawlIpHandle crawlIpHandle;
    /**
     * 通过代理ip爬取可用ip
     * @return
     */
    @Override
    public void crawlIp() {
        SpiderProxyIpInfo practicableIp = service.getPracticableIp();
        String host = "";
        Integer port = null;
        if (ObjectUtils.isNotEmpty(practicableIp)) {
            host = practicableIp.getHost();
            port = practicableIp.getPort();
        }
        crawlIpHandle.execute(host,port,targetIpList);
    }
}
