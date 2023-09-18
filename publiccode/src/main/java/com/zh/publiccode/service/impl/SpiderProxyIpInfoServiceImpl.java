package com.zh.publiccode.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.zh.publiccode.common.CommonMethod;
import com.zh.publiccode.dao.SpiderProxyIpInfoMapper;
import com.zh.publiccode.entity.SpiderProxyIpInfo;
import com.zh.publiccode.service.SpiderProxyIpInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.io.IOException;

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


        // 1读取库中一条可用的ip作为代理服务器
        // 1.1 TODO 先读十条，如果都失效了在读十条
        // 1.2 库中没有可用ip，则使用本机ip
        SpiderProxyIpInfo practicableIp = getPracticableIp();




        return null;
    }

    @Override
    public SpiderProxyIpInfo getPracticableIp() {
        boolean practicable = false;

        boolean result = false;
        while (!result) {
            SpiderProxyIpInfo spiderProxyIpInfo = spiderProxyIpInfoMapper.selectOne(new QueryChainWrapper<>(SpiderProxyIpInfo.class));
            if (!ObjectUtils.isEmpty(spiderProxyIpInfo)) {
                String ipStr = spiderProxyIpInfo.getHost();
                Integer port = spiderProxyIpInfo.getPort();
                Integer id = spiderProxyIpInfo.getId();
                String ip = ipStr + ":" + port;
                try {
                    // 校验ip
                    practicable = CommonMethod.checkIP(ip);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (practicable) {
                    // 获取可用ip直接返回
                    return spiderProxyIpInfo;
                } else {
                    // ip不可用，删除
                    spiderProxyIpInfoMapper.deleteById(id);
                }

            }

            if (ObjectUtils.isEmpty(spiderProxyIpInfo)) {
                // 库中暂无数据，退出循环
                result = true;
            }
        }
        return null;
    }
}
