package cn.zsza.design_pattern.singleton.hungry;

/**
 * Created by zs on 2017/7/25.
 * 16:38
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
