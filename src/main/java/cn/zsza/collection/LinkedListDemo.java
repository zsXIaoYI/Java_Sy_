package cn.zsza.collection;

import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

/**
 * Created By zhangsong
 * 21:20 2018/9/17
 */
public class LinkedListDemo {
	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("c");

		String e1 = list.element();
		System.out.println(e1);     // 返回第一个元素

		list.offer("d");
		System.out.println(list);   // 在尾部添加元素


		System.out.println(list.poll());    // 移除头部元素
		System.out.println("after poll list: " + list);

		System.out.println(list.peek());    // 返回头部元素，其list不改变
		System.out.println("after peek list: " + list);

		System.out.println(list.peekFirst() + " after peekFirst list: " + list);

	}
}
