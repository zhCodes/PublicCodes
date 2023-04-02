package main.java.designmode;

/**
 * @author Zhanghuihui
 * @date 2023/2/18 15:23
 * @description 单例 懒汉式
 */
public class SingletonLazyMode {

  private SingletonLazyMode(){

  }
  private static  SingletonLazyMode singletonLazyMode;

  public  static   SingletonLazyMode getInstance(){

    if (singletonLazyMode==null){
      return new SingletonLazyMode();
    }
    return singletonLazyMode;
  }


}
