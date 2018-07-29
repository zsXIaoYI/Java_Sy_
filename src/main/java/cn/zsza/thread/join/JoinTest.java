package cn.zsza.thread.join;

/**
 * Created By zhangsong
 * 11:13 2018/7/29
 *
 * 主线程创建并启动子线程,如果子线程中要进行大量的耗时运算，主线程往往将早于子线程之前结束。
 * 这时，如果主线程想等待子线程执行完毕之后再结束，比如子线程处理一个数据，主线程要取得这个数
 * 据，主线程要取得这个数据的值，就要用到join()方法了
 */
public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		MyThread my = new MyThread();
		my.start();
		/**
		 * 对于MyThread中Thread.sleep()根本不知道设置多少毫秒，所以下面一行
		 * 代码特意设置的很大，解决的办法就是用join
		 */
//		Thread.sleep(10000);
		my.join();
		System.out.println("我想my对象执行完毕后再执行");
	}
}
