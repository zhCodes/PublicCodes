package com.zh.publiccode.testwebspider;

import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description 解析html
 */
public class MyProcessor implements PageProcessor {

    @Override
    public void process(Page page) {

        String pageHtml = page.getHtml().get();
        // System.out.println(pageHtml);
        Document pageHtmlDoc = Jsoup.parse(pageHtml);
        ArrayList<Object> connectionList = Lists.newArrayList();
        Elements title = pageHtmlDoc.select("title");
        // System.out.println("title: "+title.text());
        page.putField("title",title.text());

        Elements select = pageHtmlDoc.select("tbody").select("tr");
        for (Element element : select) {
            // System.out.println(element);
            connectionList.add(element.text());
        }

        page.putField("contents",connectionList);
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setRetryTimes(0)
                .setSleepTime(1000)
                .setTimeOut(5000);

    }

}
