package cn.zsza.data_structure;

import org.junit.Test;
/**
 * Created by ZhangSong on 2017/9/23.
 * 17:30
 * 进制转换
 */
public class BinaryConvert {
    // 十进制转换成二级制
    @Test
    public void testTen_Two(){
        int num = 10;
        StringBuffer sb = new StringBuffer();
        while(num > 0){
            sb.append(num % 2);
            num = num/2;
        }
        System.out.println("十进制数转换二进制位："+sb.reverse());
    }
}
