package com.zh.publiccode.testwebspider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghuihui
 * @date 2023/9/14
 * @description
 */
public class CheckIp {
    public static void main(String[] args) throws Exception {
        getIp();
    }
 public static void getIp() throws Exception {

     List<String> list = new ArrayList<>();
     String starturl = "https://proxy.ip3366.net/free/"; //获取动态ip的网址


     URL url = new URL(starturl);

     //通过url建立连接
     HttpURLConnection conn = (HttpURLConnection) url.openConnection();

     //通过连接取得网页返回数据
     InputStream in = conn.getInputStream();
     BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
     //遍历br,将br中的数据存入到list中


     while (br.readLine() != null) {
//            System.out.println(br.readLine() + "正在添加到list中");
         String s = br.readLine();

         list.add(s);
     }
     br.close();
     in.close();
     for (String s : list) {
         System.out.println(s);
     }


 }





    //验证一下ip是否可用;True可用;False不可用
    private static boolean yanzheng(String ip) throws IOException {
        try {
            if (ip.contains(":") && ip != null) {
                String starturl = "http://www.baidu.com";
                URL url = new URL(starturl);
                //通过url建立连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //设置代理
                String[] split = ip.split(":");
                String ip1 = split[0];
                String port = split[1];
                InetSocketAddress addr = new InetSocketAddress(ip1, Integer.parseInt(port));
                Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理
                conn = (HttpURLConnection) url.openConnection(proxy);
                //通过连接取得网页返回数据
                //如果响应时间超过5秒，说明ip不可用
                conn.setConnectTimeout(3000);
                InputStream in = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                //如果br中有数据,则说明ip可用
                if (br.readLine() != null) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }


        return false;
    }
    }
