package cn.zsza.thread.td_communicate;

/**
 * Created By zhangsong
 * 9:03 2018/7/8
 */
public class ThreadA extends Thread {

	private MyList list;

	public ThreadA(MyList list) {
		super();
		this.list = list;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				list.add();
				System.out.println("添加了 " + (i + 1) + " 个元素");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
