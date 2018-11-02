package cn.zsza.oop;

/**
 * Created By zhangsong
 * 20:34 2018/9/7
 */
public class Cat extends Animal {
	@Override
	public void eat() {
		System.out.println("eat fish");
	}
	@Override
	public void run() {
		System.out.println("cat is running");
	}

	public static void main(String[] args) {

		Animal al = new Cat();
		al.eat();
		al.run();

		System.out.println(1 << 2);
	}
}
