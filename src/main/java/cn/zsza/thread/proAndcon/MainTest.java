package cn.zsza.thread.proAndcon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * Created By zhangsong
 * 20:37 2018/9/13
 */
public class MainTest {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(2);
		Consumer con = new Consumer(blockingQueue);
		Producer pro = new Producer(blockingQueue);

		for (int i = 1; i <= 5; i++){
			new Thread(pro, "producer" + i).start();
			new Thread(con, "producer" + i).start();
		}
//		new Thread(pro, "producer" + 1).start();
//		new Thread(pro, "producer" + 2).start();
//		new Thread(pro, "producer" + 3).start();
//		new Thread(pro, "producer" + 4).start();
//		new Thread(pro, "producer" + 5).start();
//
//
//		new Thread(con, "consumer" + 1).start();
//		new Thread(con, "consumer" + 2).start();
//		new Thread(con, "consumer" + 3).start();
//		new Thread(con, "consumer" + 4).start();
//		new Thread(con, "consumer" + 5).start();
	}
}
