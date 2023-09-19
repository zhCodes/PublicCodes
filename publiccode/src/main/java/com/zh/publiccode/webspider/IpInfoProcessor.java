package com.zh.publiccode.webspider;

import com.zh.publiccode.entity.SpiderProxyIpInfo;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


import java.util.ArrayList;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description 获取网站ip信息
 */
public class IpInfoProcessor implements PageProcessor {

    @Override
    public void process(Page page) {

        String pageHtml = page.getHtml().get();
        Document pageHtmlDoc = Jsoup.parse(pageHtml);
        ArrayList<SpiderProxyIpInfo> connectionList = Lists.newArrayList();

        Elements select = pageHtmlDoc.select("tbody");
        // Elements select = pageHtmlDoc.select("table[class=table table-bordered table-striped]");

        for (Element element : select) {
            // System.out.println(element);
            Elements select1 = element.select("tr");
            for (Element element1 : select1) {
                SpiderProxyIpInfo spiderProxyIpInfo = new SpiderProxyIpInfo();
                Elements IP = element1.select("td[data-title=IP]");
                String ipText = IP.text();
                if (StringUtils.isNotEmpty(ipText)){
                    spiderProxyIpInfo.setHost(ipText);
                }
                Elements port = element1.select("td[data-title=PORT]");
                String portText = port.text();
                if (StringUtils.isNotEmpty(portText)){
                    spiderProxyIpInfo.setPort(Integer.valueOf(portText));
                }

                Elements typeElement = element1.select("td[data-title=类型]");
                String type = typeElement.text();
                if (StringUtils.isNotEmpty(type)){
                    spiderProxyIpInfo.setType(type);
                }
                Elements addressElement = element1.select("td[data-title=位置]");
                String address = addressElement.text();
                if (StringUtils.isNotEmpty(address)){
                    spiderProxyIpInfo.setAddr(address);
                }


                connectionList.add( spiderProxyIpInfo);

            }

        }
        System.out.println("爬取到的内容contents: "+connectionList.toString());
        page.putField("contents",connectionList);
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setRetryTimes(2)
                .setSleepTime(10000)
                .setTimeOut(10000);

    }
}
