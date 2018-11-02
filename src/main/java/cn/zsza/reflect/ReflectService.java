package cn.zsza.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created By zhangsong
 * 12:48 2018/8/21
 */
public class ReflectService {
	public void sayHello(String name){
		System.err.println("hello " + name);
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		/**
		 * 返回cn.zsza.reflect.ReflectService
		 */
		System.out.println(ReflectService.class.getName());
		Class<?> aClass = Class.forName(ReflectService.class.getName());
		Method sayHello = aClass.getMethod("sayHello", String.class);
		sayHello.invoke(aClass.newInstance(),"kitty");
	}
}
