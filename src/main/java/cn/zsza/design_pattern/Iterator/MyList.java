package cn.zsza.design_pattern.Iterator;

/**
 * Created By zhangsong
 * 11:17 2018/9/8
 */
public class MyList<E> implements AbstractList<E> {

	private Object[] es;
	private int position = 0;

	public MyList() {
		this.es = new Object[1024];
	}

	public MyList(int selfSize) {
		this.es = new Object[selfSize];
	}

	@Override
	public void add(E o) {
		es[position] = o;
		position += 1;
	}

	@Override
	public Iterator createIterator() {
		return new MyIterator(es);
	}
}
