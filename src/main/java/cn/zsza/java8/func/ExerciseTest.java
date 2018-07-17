package cn.zsza.java8.func;

import cn.zsza.java8.appleDemo.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created By ZhangSong
 * Time 2018/5/11 9:06
 * Company: Bank Of HS
 */
public class ExerciseTest {


	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> newList = new ArrayList<>();

		forEach(integerList,i -> {
			if (i / 2 == 1){
				int a = i * i;
				newList.add(a);
			}
		});
		System.out.println(newList);


		/**
		 * String::length
		 * (String s) -> {return s.length();}
		 * (String s) -> s.length()
		 * s -> s.length()
		 */
		List<Integer> list = map(Arrays.asList("java", "ca", "like"), s -> s.length());

		System.out.println(list);


		IntPredicate intPredicate = (int i) -> i % 2 == 0;
		System.out.println(intPredicate.test(100));

		/**
		 * Supplier用法
		 * Apple::new 等价于() -> new Apple();
		 */
		Supplier<Apple> a1 = Apple::new;
		System.out.println(a1.get()==a1.get());   // false

		/**
		 * 等同于 Function<Integer,Apple> ff = (weight) -> new Apple(weight);
		 */
		Function<Integer,Apple> f = Apple::new;
		Apple a2 = f.apply(10);
		System.out.println(a2);

		/**
		 * 使用Apple::new
		 */
		List<Integer> weights = Arrays.asList(7, 3, 4, 10);
		List<Apple> appleList = map(weights, Apple::new);
		System.out.println(appleList);
		/**
		 * 两个参数的构造函数
		 */
		BiFunction<Integer,String,Apple> b = Apple::new;
		Apple green = b.apply(10, "green");
		System.out.println(green);
	}


	public static <T> void forEach(List<T> list, Consumer<T> c){
		list.stream().forEach(l -> c.accept(l));
	}

	/**
	 *
	 * @param list
	 * @param f
	 * @param <T>
	 * @param <R>
	 * @return
	 */
	public static <T,R> List<R> map(List<T> list, Function<T,R> f){
		List<R> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(f.apply(l)));
		return result;
	}
}
