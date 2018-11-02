package cn.zsza.thread.proAndcon;

import com.google.common.base.Strings;

import java.util.concurrent.BlockingQueue;
/**
 * Created By zhangsong
 * 20:25 2018/9/13
 */
public class Producer implements Runnable {

	private BlockingQueue<String> bq;
	public Producer(BlockingQueue bq) {
		this.bq = bq;
	}
	@Override
	public void run() {
		try {

			String name = Thread.currentThread().getName();
			String pro = name + "'s product";
			System.out.println(name + ": I have made a product");
			bq.put(pro);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
