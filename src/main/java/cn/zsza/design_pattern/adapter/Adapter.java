package cn.zsza.design_pattern.adapter;

/**
 * Created by zs on 2017/8/18.
 * 10:01
 * 适配器(Adaper)角色
 */
public class Adapter extends Adaptee implements Target {

    /**
     *  由于源类Adaptee没有方法sampleOperation2()
     *  因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        System.out.println("......sampleOperation2");
    }

}
