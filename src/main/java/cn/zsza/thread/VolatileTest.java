package cn.zsza.thread;

/**
 * Created By zhangsong
 * 18:48 2018/8/13
 */
public class VolatileTest implements Runnable {

	private volatile int a = 0;
	@Override
	public void run() {
		for (int i = 0; i < 5; i++){
			a++;
			System.out.println("thread name: " + Thread.currentThread().getName() + ".." + a);
		}
	}

	public static void main(String[] args) {
		VolatileTest v = new VolatileTest();
		Thread t1 = new Thread(v);
		Thread t2 = new Thread(v);

		t1.start();
		t2.start();
	}
}
