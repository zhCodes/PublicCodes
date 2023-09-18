package com.zh.publiccode.webspider;

import com.zh.publiccode.entity.SpiderProxyIpInfo;
import org.springframework.util.CollectionUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Collections;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/18
 * @description
 */
public class ProxyIpInfoPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<SpiderProxyIpInfo> spiderProxyIpInfoList = resultItems.get("contents");

        if (!CollectionUtils.isEmpty(spiderProxyIpInfoList)){

            for (SpiderProxyIpInfo spiderProxyIpInfo : spiderProxyIpInfoList) {


            }
        }

    }
}

