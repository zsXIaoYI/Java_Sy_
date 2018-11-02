package cn.zsza.thread.oddAndEven;

import java.util.concurrent.locks.Lock;

/**
 * Created By zhangsong
 * 23:40 2018/9/7
 */
public class OddThread implements Runnable {

	private Symbol symbol;

	public OddThread(Symbol symbol) {
		this.symbol = symbol;
	}

	@Override
	public void run() {
		while (symbol.getNum() <= 100){
			if (!symbol.isFlag()){
				symbol.getLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() + " num:" + symbol.getNum());
					symbol.setNum(symbol.getNum() + 1);
					symbol.setFlag(true);
				}finally {
					symbol.getLock().unlock();
				}
			}
		}
	}
}
