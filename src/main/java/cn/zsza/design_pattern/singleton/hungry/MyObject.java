package cn.zsza.design_pattern.singleton.hungry;

/**
 * Created by zs on 2017/7/25.
 * 16:34
 * 饿汉式
 *   一开始就创建对象
 */
public class MyObject {
    private static MyObject myObject = new MyObject();

    private MyObject(){}

    public static MyObject getInstance(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
