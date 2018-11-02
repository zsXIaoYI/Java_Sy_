package cn.zsza.zz;

/**
 * Created By zhangsong
 * 20:52 2018/8/6
 */
public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");

		operator(a,b);

		System.out.println(a);
		System.out.println(b);

		change(a);
		System.out.println("final:" + a);

	}

	public static void operator(StringBuffer x, StringBuffer y){
		x.append(y);
		y = x;
		System.out.println("y:" + y);
	}

	public static void change(StringBuffer strBuf) {
		strBuf = new StringBuffer("cc");
		strBuf.append("hie");
	}
}
