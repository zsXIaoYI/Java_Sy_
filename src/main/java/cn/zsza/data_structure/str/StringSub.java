package cn.zsza.data_structure.str;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created By zhangsong
 * 15:52 2018/8/24
 */
public class StringSub {
	public static void main(String[] args) {
		String str = "1234";
		String result = print(str);
		System.out.println(result);
	}
	private static String print(String inputStr) {
		int len = inputStr.length();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < len; i ++){
			result.append(tempAdd(i, inputStr));
		}
		return result.toString();
	}
	/**
	 *
	 * @param i 0 1 2 3
	 * @param inputStr
	 * @return
	 * 比如当i=1时,j 等于0 和 1
	 * 截取的字符串长度分别为，0到3 和 1到4
	 * 表达式：len - i + j
	 */
	private static String tempAdd(int i, String inputStr) {
		checkNotNull(inputStr);
		int len = inputStr.length();
		StringBuilder temp = new StringBuilder();
		for (int j = 0; j <= i; j++) {
			if (j == len - 1) {
				temp.append(inputStr,j,len - i + j);       // 去掉最后一个逗号
			}else {
				temp.append(inputStr,j,len - i + j).append(",");
			}
		}
		return temp.toString();
	}
}
