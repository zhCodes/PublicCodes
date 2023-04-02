package main.java.thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhanghuihui
 * @Date 2022/11/22 18:20
 * @Description
 */
public class ServiceMethod {

  /**
   * 假如方法执行需要两秒
   */
  public String serviceMethod(String name) throws InterruptedException {
    Thread.sleep(2000);
    return name + "发送成功";
  }

  public static void test() throws Exception {
    User user = (User) Class.forName("main.java.thread.User").newInstance();
    user.setName("张三");
    System.out.println(user.getName());
  }

  public static void main(String[] args) throws Exception {
    User s = new User();
    s.setName("张三");
    User s2 = s;
    s.setName("李四");
    ConcurrentHashMap map = new ConcurrentHashMap();
    map.put("a", "a");
    System.out.println(s2.getName());
    System.out.println(s.equals(s2));
  }
}
