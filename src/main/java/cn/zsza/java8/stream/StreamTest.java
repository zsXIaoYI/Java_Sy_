package cn.zsza.java8.stream;

import org.junit.Test;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;
/**
 * Created By ZhangSong
 * Time 2018/5/15 16:22
 *
 */
public class StreamTest {

	private static  List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

	/**
	 * toList()
	 */
	@Test
	public void stream(){
		List<String> collected = Stream.of("a", "b", "c")
				.collect(Collectors.toList());
		assertEquals(Arrays.asList("a", "b", "c"), collected);

	}
	/**
	 * map: 映射
	 *  将一种类型的流转换成另一种类型的流
	 * map可以多次连接
	 */
	@Test
	public void test1(){
		List<String> list = Arrays.asList("Hello","World");
		/**
		 * 返回一个List<String[]>
		 */
		List<String[]> collect = list.stream()
				  .map(word -> word.split(""))
				  .distinct()
				  .collect(toList());

		collect.stream().forEach(a ->{
			for (String str: a) {
				System.out.println(str);
			}
			System.out.println("end");
		});
	}
	/**
	 * flatMap
	 */
	@Test
	public void test2(){
		List<String> list = Arrays.asList("Hello","World");

		List<String> result = list.stream()
				  .map(word -> word.split(""))
				  .flatMap(Arrays::stream)
				  .distinct()
				  .collect(toList());

		System.out.println(result);
	}

	/**
	 * 返回:
	 *   [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
	 */
	@Test
	public void test2_(){
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<String> result = numbers1.stream()
				  .flatMap(i -> numbers2.stream().
							 map(j -> "(" + i + "," + j + ")")
				  ).collect(toList());
		System.out.println(result);
	}
	/**
	 * limit用法
	 * 从列表中过滤能被2整除的数据，然后取第一个
	 */
	@Test
	public void test3(){
		List<Integer> result = integerList.stream()
				  .filter(i -> i % 2 == 0)
				  .limit(1)
				  .collect(toList());
		System.out.println("result:" + result);
	}
	/**
	 * skip用法
	 * limit(1)和skip(1)互补
	 */
	@Test
	public void test4(){
		List<Integer> result = integerList.stream()
				  .filter(i -> i % 2 == 0)
				  .skip(1)
				  .collect(toList());
		System.out.println("result:" + result);
	}
	/**
	 * anyMatch(): 至少一个匹配, 则返回true
	 * allMatch(): 全部匹配, 则返回true
	 * noneMatch(): 都不匹配, 则返回true
	 * findAny(): 筛选后, 则返回
	 * findFirst(): 找到第一个元素在并行上限制更多, 如果你不关心返回的元素是哪个，
	 *   请用findAny()
	 */
	@Test
	public void test5(){
		List<Integer> list = Arrays.asList(7, 1, 2, 4);
//		boolean b = list.stream()
//				  .noneMatch(i -> i > 5);
//		System.out.println(b);
		Optional<Integer> op = list.stream().filter(i -> i % 2 == 1).findAny();
		System.out.println(op.get());
	}
	/**
	 * reduce: 规约
	 *  reduce(0, (a, b) -> a + b);  返回Integer
	 *  reduce(0, Integer::sum);  返回Integer
	 *  reduce(Integer::sum); 返回Optional<Integer>
	 *  计算过程：
	 *   0 7 1 2 4
	 *   a b       // a+b 赋值给a
	 *     a b        b后移
	 */
	@Test
	public void test6(){
		List<Integer> list = Arrays.asList(7, 1, 2, 4);
//		Optional<Integer> re = list.stream()
//				  .reduce(Integer::sum);
//		System.out.println(re.get());

		Integer result = list.stream()
				.reduce(0, (a, b) -> a + b);
		System.out.println(result);

		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	/**
	 * collect
	 */
	@Test
	public void test7(){
		BiConsumer<List,List> cb = (l1, l2) ->{
			l1.addAll(l2);
		};
		List<String> list1 =
				Stream.of(1, 2, 3, 4, 5)
						.collect(() -> new ArrayList<>(),
								(l, i) -> l.add(i + "i"),
								cb);
		System.out.println(list1);

		List<Person> people = new ArrayList<>();
		people.add(new Person("xx",10));
		people.add(new Person("cc",12));
		people.add(new Person("yy",12));
		List<Map<String,Object>> personToMap = people.stream()
				.collect(ArrayList::new,(list,p) -> {
					Map<String,Object> map = new HashMap<>();
					map.put("name",p.name);
					map.put("age",p.age);
					list.add(map);
				},List::addAll);
		System.out.println(personToMap);
		System.out.println(people);
	}

	static class Person{
		public String name;
		public int age;
		Person(String name, int age){
			this.name = name;
			this.age = age;
		}
	}
}
