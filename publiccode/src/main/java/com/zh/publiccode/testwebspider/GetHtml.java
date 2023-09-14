package com.zh.publiccode.testwebspider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public class GetHtml {

    public void execute(List<String> list) {


        String[] array = list.toArray(new String[]{});

        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                // 设置代理ip
                new Proxy("1.117.76.28",7890)
        ));
        Spider spider = Spider
                // 指定页面解析器
                .create(new MyProcessor())
                // 指定爬取结果的处理器
                .addPipeline(new MyPipeline())
                .setDownloader(httpClientDownloader)
                // .setScheduler(new QueueScheduler()
                //         .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                // 创建3个线程
                .addUrl(array)
                .thread(3);
        // 异步爬取

        spider.start();
    }
}
