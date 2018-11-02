package cn.zsza.thread.oddAndEven;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By zhangsong
 * 23:39 2018/9/7
 */
@Data
public class Symbol {

	private int num = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();
}
