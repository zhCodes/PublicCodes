package com.zh.publiccode.webspider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zh.publiccode.common.CommonMethod;
import com.zh.publiccode.dao.SpiderProxyIpInfoMapper;
import com.zh.publiccode.entity.SpiderProxyIpInfo;
import com.zh.publiccode.service.SpiderProxyIpInfoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/18
 * @description
 */
@Component
public class ProxyIpInfoPipeline implements Pipeline {

    @Resource
    private SpiderProxyIpInfoService spiderProxyIpInfoService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<SpiderProxyIpInfo> spiderProxyIpInfoList = resultItems.get("contents");

        if (!CollectionUtils.isEmpty(spiderProxyIpInfoList)) {

            for (SpiderProxyIpInfo spiderProxyIpInfo : spiderProxyIpInfoList) {
                String host = spiderProxyIpInfo.getHost();
                Integer port = spiderProxyIpInfo.getPort();
                String ip = host + ":" + port;
                try {
                    boolean b = CommonMethod.checkIP(ip);
                    if (b) {

                        QueryWrapper<SpiderProxyIpInfo> sWrapper=new QueryWrapper<>();
                        sWrapper.eq("host",host);
                        sWrapper.eq("port",port);
                        SpiderProxyIpInfo spiderProxyIpInfo1 = spiderProxyIpInfoService.getOne(sWrapper,false);
                        if (ObjectUtils.isEmpty(spiderProxyIpInfo1)){
                            System.out.println("可用ip:"+host+":"+port+"，入库");
                            spiderProxyIpInfoService.saveOrUpdate(spiderProxyIpInfo);
                        }else {
                            System.out.println("可用ip:"+host+":"+port+"，已存在");
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}

