package com.zh.publiccode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zh.publiccode.config.Response;
import com.zh.publiccode.entity.SpiderProxyIpInfo;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public interface SpiderProxyIpInfoService extends IService<SpiderProxyIpInfo> {

    /**
     * 可用ip进行入库
     */
   Object saveIpInfo();

    /**
     * 获取库中可用ip
     * @return
     */
   SpiderProxyIpInfo getPracticableIp();




}
