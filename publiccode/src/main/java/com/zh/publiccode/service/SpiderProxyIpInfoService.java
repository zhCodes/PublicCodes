package com.zh.publiccode.service;

import com.zh.publiccode.config.Response;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public interface SpiderProxyIpInfoService {

    /**
     * 爬取可用ip进行入库
     */
   Object saveIpInfo();


}
