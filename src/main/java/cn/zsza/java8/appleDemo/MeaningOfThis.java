package cn.zsza.java8.appleDemo;

/**
 * @Author: ZhangSong
 * @Date: Created In 17:18 2018/5/8
 * @Company: Bank Of HengShui
 */
public class MeaningOfThis {

	public final int value = 4;
	public void  doIt(){
		int value = 6;
		new Runnable(){
			public final int value = 5;
			@Override
			public void run() {
				int value = 10;
				System.out.println("value:" + this.value);
			}
		}.run();
	}

	public static void main(String[] args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt();

		new Thread(() -> System.out.println(111)).start();
	}
}
