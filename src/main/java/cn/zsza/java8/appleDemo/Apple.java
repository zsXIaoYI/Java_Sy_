package cn.zsza.java8.appleDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangSong
 * @Date: Created In 16:05 2018/5/4
 * @Company: Bank Of HengShui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
	private Integer weight;
	private String color;


	public Apple(Integer weight) {
		this.weight = weight;
	}

	/**
	 * 判断苹果是否为绿色
	 * @return
	 */
	public boolean isGreenApple(){
		return "green".equals(this.color);
	}
}
