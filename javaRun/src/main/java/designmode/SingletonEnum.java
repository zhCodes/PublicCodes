package main.java.designmode;

/**
 * @author Zhanghuihui
 * @date 2023/2/18 16:05
 * @description
 */
public class SingletonEnum {

  private SingletonEnum(){

  }
  private static enum SinEnum{
    SIN;
    private SingletonEnum singletonEnum=new SingletonEnum();
  }

  public static SingletonEnum getInstance(){
    SinEnum s=SinEnum.SIN;

    return s.singletonEnum;
  }

}
