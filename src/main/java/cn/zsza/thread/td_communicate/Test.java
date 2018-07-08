package cn.zsza.thread.td_communicate;

/**
 * Created By zhangsong
 * 9:11 2018/7/8
 * 测试情况: B线程执行不到自己的代码，可能一直没有获取CPU执行权
 */
public class Test {
	public static void main(String[] args) {
		MyList service = new MyList();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();



	}
}
