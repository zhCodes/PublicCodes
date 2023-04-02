package main.java.designmode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Zhanghuihui
 * @date 2023/2/18 15:17
 * @description 单例 饿汉式
 */
public class SingletonEagerMode {


  public SingletonEagerMode(){

  }
  private static SingletonEagerMode singletonEagerMode=new SingletonEagerMode();

  public static SingletonEagerMode getInstance(){
    return singletonEagerMode;
  }


}
