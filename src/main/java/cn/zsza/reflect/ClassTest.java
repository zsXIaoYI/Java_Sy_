package cn.zsza.reflect;

import java.lang.reflect.Method;

/**
 * Created by zs on 2017/4/27.
 * 17:03
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("当前线程:" + Thread.currentThread().getName());
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // 加载类
        Class<?> aClass = loader.loadClass("cn.zsza.reflect.Person");

        // 拿到类的方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods){
            System.out.println("method name=" + method.getName());
        }
    }
}
