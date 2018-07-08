package cn.zsza.thread.td_communicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By zhangsong
 * 9:01 2018/7/8
 */
public class MyList {

	private List list = new ArrayList();

	public void add(){
		list.add("something");
	}

	public int size(){
		return list.size();
	}
}
