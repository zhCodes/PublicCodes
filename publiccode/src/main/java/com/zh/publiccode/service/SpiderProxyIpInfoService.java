package com.zh.publiccode.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zh.publiccode.config.Response;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public interface SpiderProxyIpInfoService {

    /**
     * 可用ip进行入库
     */
   Object saveIpInfo();

    /**
     * 获取库中可用ip
     * @return
     */
   Object getPracticableIp();




}
