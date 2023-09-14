package com.zh.publiccode.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.zh.publiccode.dao.SpiderProxyIpInfoMapper;
import com.zh.publiccode.entity.SpiderProxyIpInfo;
import com.zh.publiccode.service.SpiderProxyIpInfoService;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
@Service
public class SpiderProxyIpInfoServiceImpl implements SpiderProxyIpInfoService {
@Resource
private SpiderProxyIpInfoMapper spiderProxyIpInfoMapper;

    @Override
    public Object saveIpInfo() {
        //1读取库中一条可用的ip作为代理服务器
        //1.1 TODO 先读十条，如果都失效了在读十条
        //1.2 库中没有可用ip，则使用本机ip
        SpiderProxyIpInfo spiderProxyIpInfo = spiderProxyIpInfoMapper.selectOne(new QueryChainWrapper<>(SpiderProxyIpInfo.class));

        String ipStr = spiderProxyIpInfo.getIp();
        Integer port = spiderProxyIpInfo.getPort();

        //2从配置文件中的代理ip网站获取ip，并校验是否可用，可用则入库


        return null;
    }
}
