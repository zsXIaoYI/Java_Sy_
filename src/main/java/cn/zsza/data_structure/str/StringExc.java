package cn.zsza.data_structure.str;

import java.util.*;
/**
 * Created By zhangsong
 * 19:59 2018/7/17
 */
public class StringExc {
	/**
	 * 给定一个字符串，指出字符串中出现一次，并且是第一次出现的字符
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abacdceffe";

		TreeSet<Character> set = new TreeSet<>();
		for (int i = 0; i < str.length(); i++){
			char tmp = str.charAt(i);
			if (!set.contains(tmp)){
				set.add(tmp);
			}else {
				set.remove(tmp);
			}
		}
		System.out.println(set);
		System.out.println(set.first());

	}
}
