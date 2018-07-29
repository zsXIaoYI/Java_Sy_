package cn.zsza.thread.join;

/**
 * Created By zhangsong
 * 11:11 2018/7/29
 */
public class MyThread extends Thread {
	@Override
	public void run() {
		try {
			int secondValue = (int) (Math.random() * 10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
