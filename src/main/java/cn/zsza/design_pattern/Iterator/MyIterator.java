package cn.zsza.design_pattern.Iterator;

/**
 * Created By zhangsong
 * 11:12 2018/9/8
 * 具体迭代器
 */
public class MyIterator<E> implements Iterator<E> {

	private E[] es;
	private int position = 0;

	public MyIterator(E[] es) {
		this.es = es;
	}

	@Override
	public boolean hasNext() {
		return position != es.length && es[position] != null;
	}

	@Override
	public E next() {
		E e = es[position];
		position += 1;
		return e;
	}
}
