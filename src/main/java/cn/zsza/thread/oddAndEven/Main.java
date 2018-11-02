package cn.zsza.thread.oddAndEven;

/**
 * Created By zhangsong
 * 23:54 2018/9/7
 * 两个线程交替打印奇数和偶数
 */
public class Main {
	public static void main(String[] args) {
		Symbol symbol = new Symbol();
		OddThread odd = new OddThread(symbol);
		EvenThread even = new EvenThread(symbol);

		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);

		t1.start();
		t2.start();
	}
}
