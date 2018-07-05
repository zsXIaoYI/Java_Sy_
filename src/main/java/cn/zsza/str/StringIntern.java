package cn.zsza.str;

/**
 * @Author: ZhangSong
 * @Date: 2018/6/20 17:11
 * @Company: NoNo
 */
public class StringIntern {

    public static void main(String[] args) {
        /**
         * 生成了2个对象,常量池中的"1"和 JAVA Heap中的字符串对象
         * s.intern():这一句是s对象去常量池中寻找后发现 “1” 已经在常量池里了。
         */
        String s = new String("1");
        s.intern();
        String s2 = "1";

        System.out.println(s == s2);  // 返回false

        String s3 = new String("a") + new String("j");
        s3.intern();
        String s4 = "aj";

        System.out.println(s3 == s4);   // true


        String s5 = "bb";
        String s6 = new String("b") + new String("b");
        s6.intern();

        System.out.println(s5 == s6);     // false
    }
}
