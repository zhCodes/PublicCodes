package main.java.thread;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:15
 * @Description
 */
public class ServiceThread2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String name = getName();
            System.out.println(name+"执行更新");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
