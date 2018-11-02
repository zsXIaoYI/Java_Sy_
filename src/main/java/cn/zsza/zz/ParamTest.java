package cn.zsza.zz;

/**
 * Created By zhangsong
 * 15:58 2018/9/6
 */
public class ParamTest {
	public static void pass(int j){
		j = 20;
		System.out.println("j:" + j);
	}

	public static void main(String[] args) {
		ParamTest pt = new ParamTest();
		int i = 10;
		pt.pass(i);
		System.out.println("i:" + i);
	}
}
