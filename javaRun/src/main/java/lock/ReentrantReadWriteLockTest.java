package main.java.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 60L
            , TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    private static int i = 100;

    public static void main(String[] args) {

        poolExecutor.execute(() -> {
            read(Thread.currentThread());
        });
        poolExecutor.execute(()->{
            write(Thread.currentThread());
        });

        poolExecutor.execute(()->{
            read(Thread.currentThread());
        });
        poolExecutor.shutdown();
    }

    private static void read(Thread thread) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        readWriteLock.readLock().lock();
        try {
            System.out.println("读线程：" + thread.getName() + " 开始执行，i=" + i);
            Thread.sleep(2000);
            System.out.println(thread.getName() + " is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

private static  void write(Thread thread){
    try {
        cyclicBarrier.await();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (BrokenBarrierException e) {
        throw new RuntimeException(e);
    }
readWriteLock.writeLock().lock();
try {


    i++;
    System.out.println("写线程 "+thread.getName()+" is doing,i="+i);
    System.out.println(thread.getName() +"is over");
}finally {
    readWriteLock.writeLock().unlock();
}
}























}
