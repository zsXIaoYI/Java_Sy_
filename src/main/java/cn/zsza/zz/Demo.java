package cn.zsza.zz;

/**
 * Created By zhangsong
 * 15:43 2018/9/6
 */
public class Demo {
	public static void main(String[] args) {
		Person p = new Person("张三");
		change(p);
		System.out.println("after change: " + p.name);
	}

	public static void change(Person p) {
		Person p1 = new Person("ggg");
		p = p1;
//		p.name = "xx";
		System.out.println(p.name);

	}
}
class Person{

	String name;

	public Person(String name) {
		this.name = name;
	}
}