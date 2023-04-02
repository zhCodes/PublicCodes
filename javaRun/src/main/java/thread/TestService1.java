package main.java.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhanghuihui
 * @Date 2022/11/20 21:14
 * @Description
 */
public class TestService1 {

    public static void testThread1() throws InterruptedException {
        ServiceThread thread1 = new ServiceThread();
        ServiceThread thread2 = new ServiceThread();
        ServiceThread thread3 = new ServiceThread();
        long s = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(3000);
        long e = System.currentTimeMillis();
        System.out.println("用时：" + (e - s));
    }

    public static void testThread2() throws InterruptedException {
        ServiceThread thread1 = new ServiceThread();
        ServiceThread2 thread2 = new ServiceThread2();
        ServiceThread3 thread3 = new ServiceThread3();
        long s = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        new Thread(thread3, "删除线程").start();
        Thread.sleep(3000);
        long e = System.currentTimeMillis();
        System.out.println("用时：" + (e - s));
    }

    public static void testThread3() throws Exception {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setName("张三");
        user2.setName("李四");
        user3.setName("王五");
        list.add(user1);
        list.add(user2);
        list.add(user3);



        long s = System.currentTimeMillis();
        int coreSize = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(coreSize);
        List<Future> listF = new LinkedList<Future>();

            ServiceThread4 thread4 = new ServiceThread4();
            thread4.setUser(list.get(0));
            FutureTask futureTask = new FutureTask<>(thread4);
       pool.submit(futureTask);




        pool.shutdown();

        long e = System.currentTimeMillis();


    }

    /**
     * CompletableFuture实现
     */
    public  static  void testThread4() throws Exception{
        List<User> list = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setName("张三");
        user2.setName("李四");
        user3.setName("王五");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        ServiceMethod serviceMethod=new ServiceMethod();
        List<String> resultList=new ArrayList<>();
        long s = System.currentTimeMillis();

        List<CompletableFuture<String>> futureList = list.stream()
                .map(e -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return serviceMethod.serviceMethod(e.getName());
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        List<String> collect = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(collect);
//        list.forEach(e->{
//            CompletableFuture comFuture =CompletableFuture.supplyAsync(()->{
//                try {
//                    return   serviceMethod.serviceMethod(e.getName());
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
//            });
////            try {
////                resultList.add((String) comFuture.get());
////            } catch (InterruptedException ex) {
////                throw new RuntimeException(ex);
////            } catch (ExecutionException ex) {
////                throw new RuntimeException(ex);
////            }
//        });

        long e = System.currentTimeMillis();
        System.out.println("用时："+(e-s));

    }



    public static void main(String[] args) throws Exception {
//        TestService1.testThread1();
//        TestService1.testThread2();
//        TestService1.testThread3();
        TestService1.testThread4();
    }
}
