package cn.zsza.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: ZhangSong
 * @Date: 2018/6/20 14:06
 * @Company: NoNo
 */
public class InputStreamAndOutputStream {
    /**
     * 字节流写入文件
     * @throws IOException
     */
    @Test
    public void testFileOutputStream() throws IOException{
        // 创建一个文件
        FileOutputStream fos = new FileOutputStream("file\\fos.txt");

        fos.write("abc".getBytes());   // 字节流不用刷新
        fos.close();
    }

    /**
     * 字节流读文件
     * @throws IOException
     */
    @Test
    public void testFileInputStream() throws IOException{
        FileInputStream fis = new FileInputStream("file\\fos.txt");
        System.out.println(".."+fis.available());   // 返回文件字符的个数

        /**
         * fos.txt中有abc三个字符，read方法每次只读一个字符，直到读到末尾为"-1"
         */
        System.out.println((char)fis.read());
        System.out.println((char)fis.read());
        System.out.println((char)fis.read());
        System.out.println(fis.read());              // 返回 -1
        int ch = 0;
//        while((ch=fis.read())!=-1){
//            System.out.println("ch="+(char)ch);
//        }
        fis.close();
    }

    @Test
    public void testFileInputStream2() throws IOException {
        FileInputStream fis = new FileInputStream("file\\fos.txt");

        System.out.println(".."+fis.available());
        byte buf[] = new byte[fis.available()];
        fis.read(buf);
        System.out.println("字节数组转换为字符串:"+new String(buf));
        fis.close();
    }

    /**
     * 负数在计算机中是以补码的形式表示
     *  -1
     *  源码：1000 0001  最高位是符号位，1表示负
     *  反码：1111 1110  符号位不变，其他位取反
     *  补码：1111 1111  补码=反码+1
     *  -1 在计算机中以补码的形式表现，其补码为1111 1111
     */
    @Test
    public void testByteArrayInputStream(){
        byte buf[] = new byte[]{15,-1,67,32};
        ByteArrayInputStream byteIns = new ByteArrayInputStream(buf);

        int data;
        while ((data=byteIns.read())!=-1){
            System.out.println("..."+data);
        }
    }
}
