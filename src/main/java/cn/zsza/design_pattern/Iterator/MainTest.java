package cn.zsza.design_pattern.Iterator;

import java.util.ArrayList;

/**
 * Created By zhangsong
 * 11:22 2018/9/8
 */
public class MainTest {
	public static void main(String[] args) {
		AbstractList<String> list  = new MyList<>();
		list.add("java");
		list.add("php");
		list.add("python");

		Iterator<String> iterator = list.createIterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
