package main.java.thread;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:15
 * @Description
 */
public class ServiceThread3 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String name = Thread.currentThread().getName();
            System.out.println(name+"执行删除");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
