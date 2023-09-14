package com.zh.publiccode.testwebspider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public class MebMagicTest {

    public static void main(String[] args) {
        // String[] url=new String[]{"http://baidu.com"};
        // String[] url=new String[]{"https://search.51job.com/list/170200,000000,0000,00,9,99,%2B,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare="};
        // String[] url=new String[]{"https://proxy.ip3366.net/free/?action=china&page=1"};
        List<String> list = new ArrayList<>();
        list.add("https://proxy.ip3366.net/free/?action=china&page=1");
        list.add("https://proxy.ip3366.net/free/?action=china&page=2");
        list.add("https://proxy.ip3366.net/free/?action=china&page=3");
        new GetHtml().execute(list);

    }



}
