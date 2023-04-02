package main.java.thread;

import java.util.concurrent.Callable;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:15
 * @Description
 */
public class ServiceThread4 implements Callable<String>{

 private   User user;
    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
         Thread.sleep(2000);
        System.out.println("方法："+name+user.getName()+"发送成功");
        return user.getName()+"发送成功";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
