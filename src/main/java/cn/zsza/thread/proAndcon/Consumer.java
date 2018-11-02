package cn.zsza.thread.proAndcon;

import java.util.concurrent.BlockingQueue;

/**
 * Created By zhangsong
 * 20:31 2018/9/13
 */
public class Consumer implements Runnable {

	private BlockingQueue<String> bq;

	public Consumer(BlockingQueue bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		try {
			String res = bq.take();
			System.out.println(Thread.currentThread().getName() + ": " + res);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
