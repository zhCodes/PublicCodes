package com.zh.publiccode.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 *公共方法类
 */
public class CommonMethod {
    // private final static String USER_="user_";
    // public static String getUserId(String id){
    //     return USER_+id;
    // }

    //验证一下ip是否可用;True可用;False不可用
    public static boolean checkIP(String ip) throws IOException {
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
