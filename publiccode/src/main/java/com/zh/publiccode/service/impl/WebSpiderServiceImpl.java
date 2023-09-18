package com.zh.publiccode.service.impl;

import com.zh.publiccode.entity.SpiderProxyIpInfo;
import com.zh.publiccode.service.WebSpiderService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    /**
     * 通过代理ip爬取可用ip
     * @param proxyIp 代理ip
     * @return
     */
    @Override
    public List<SpiderProxyIpInfo> crawlIp(SpiderProxyIpInfo proxyIp) {
        if (!ObjectUtils.isEmpty(proxyIp)){
            String addr = proxyIp.getAddr();
            Integer port = proxyIp.getPort();


        }



        return null;
    }
}
