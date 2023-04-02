package main.java.designmode;

/**
 * @author Zhanghuihui
 * @date 2023/2/18 15:56
 * @description
 */
public class SingletonDoubleCheckMode {

  private SingletonDoubleCheckMode(){

  }
  private static SingletonDoubleCheckMode singletonDoubleCheckMode;

  public static SingletonDoubleCheckMode getInstance(){

    if(singletonDoubleCheckMode==null){
      synchronized (SingletonDoubleCheckMode.class){
        if (singletonDoubleCheckMode==null){
          return new SingletonDoubleCheckMode();
        }
      }

    }
    return singletonDoubleCheckMode;

  }

}
