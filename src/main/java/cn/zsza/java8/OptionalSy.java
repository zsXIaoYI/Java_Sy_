package cn.zsza.java8;

import java.util.Optional;

/**
 * Created By zhangsong
 * 22:11 2018/7/18
 */
public class OptionalSy {

	public static void main(String[] args) {


		Optional<String> opt = Optional.empty();   // 返回一个Optional对象
		System.out.println(opt);

		Optional<String> opt1 = Optional.ofNullable(null);
		System.out.println(opt1);
		System.out.println(opt1.get());

//		Optional<String> opt2 = Optional.of(null);   // 直接空指针异常
//		System.out.println(opt2);
	}
}
