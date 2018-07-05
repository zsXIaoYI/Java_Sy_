package cn.zsza.java8.try_;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewTry {
	@Test
	public void processFile() throws IOException {
		/**
		 * 括号里的内容支持包括流以及任何可关闭的资源，数据流会在 try 执行完毕后自动被关闭，而不用我们手动关闭了
		 */
		try (BufferedReader br = new BufferedReader(new FileReader("file/data.txt"))){
			String temp;
			while ((temp = br.readLine()) != null){
				System.out.println(temp);
			}
		}
	}
	@Test
	public void test1(){

		List<Integer> list = Arrays.asList(2, 1, 3, 4, 4, 6);
		System.out.println(list);

		List<Integer> result = list.stream().filter(i -> i > 2)
				  .skip(3).collect(Collectors.toList());

		System.out.println(result);
	}

}
