package com.zh.publiccode.webspider;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/18
 * @description 爬取代理ip
 */
@Component
public class CrawlIpHandle {

    @Resource
    private ProxyIpInfoPipeline pipeline;

    public void execute(String host,Integer port,List<String> targetIpAddrList) {
        String[] array = targetIpAddrList.toArray(new String[]{});

        if (StringUtils.isNotEmpty(host)&&port!=null){
            HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
            httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                    // 设置代理ip
                    // new Proxy("1.117.76.28",7890)
                    new Proxy(host,port)
            ));

            Spider spider = Spider
                    // 指定页面解析器
                    .create(new IpInfoProcessor())
                    // 指定爬取结果的处理器
                    .addPipeline(pipeline)
                    .setDownloader(httpClientDownloader)
                    // .setScheduler(new QueueScheduler()
                    //         .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                    // 创建3个线程
                    .addUrl(array)
                    .thread(3);
            // 异步爬取

            spider.start();
        }else {
            Spider spider = Spider
                    // 指定页面解析器
                    .create(new IpInfoProcessor())
                    // 指定爬取结果的处理器
                    .addPipeline(pipeline)
                    // .setScheduler(new QueueScheduler()
                    //         .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                    // 创建3个线程
                    .addUrl(array)
                    .thread(3);
            // 异步爬取

            spider.start();
        }



    }
}
