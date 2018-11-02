package cn.zsza.design_pattern.Iterator;

/**
 * Created By zhangsong
 * 11:15 2018/9/8
 *  抽象容器
 */
public interface AbstractList<E> {
	void add(E e);
	Iterator<E> createIterator();
}
