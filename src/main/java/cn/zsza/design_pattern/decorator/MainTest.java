package cn.zsza.design_pattern.decorator;

/**
 * Created By zhangsong
 * 17:55 2018/7/7
 */
public class MainTest {
	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		TheGreatestSage fish = new Fish(sage);
		fish.move();
	}
}
