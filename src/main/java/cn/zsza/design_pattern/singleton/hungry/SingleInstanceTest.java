package cn.zsza.design_pattern.singleton.hungry;

import cn.zsza.design_pattern.singleton.lazy.MyThread;

/**
 * Created by zs on 2017/7/25.
 * 16:37
 */
public class SingleInstanceTest {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}
