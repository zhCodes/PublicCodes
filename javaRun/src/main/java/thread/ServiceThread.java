package main.java.thread;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:15
 * @Description
 */
public class ServiceThread  extends Thread{

    private  static ThreadLocal  threadLocal=new ThreadLocal<>();
    @Override
    public void run() {
        try {
            String str="aaa";
            threadLocal.set(str);
            Thread.sleep(2000);
            String name = getName();
            System.out.println(name+"执行查询");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
