package cn.zsza.io;

import org.junit.Test;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @Author: ZhangSong
 * @Date: 2018/6/20 13:54
 * @Company: NoNo
 */
public class FileReaderAndWriter {
    @Test
    public void testFileReader() throws IOException {
        FileReader fr = new FileReader("file\\cc.txt");
        int ch;
        int i = 0;
        /**
         *  read方法读取单个字符,一次读一个字符，读完一个往下继续读一个
         */
        while((ch=fr.read())!=-1){
            System.out.println("ch="+(char)ch);
            i++;
        }
        System.out.println("i="+i);
    }

    /**
     * FileReader读取到字符数组中
     */
    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("file\\cc.txt");
        char buf[] = new char[3];
        /**
         * 如果读取的文件中的字符个数超过上述定义的字符数组大小
         * 则会先打印一个字符数组个数的字符串
         */
        //char buf[] = new char[1024];  一个2KB的字符数组
        int num;
        int i = 0;
        while((num=fr.read(buf))!=-1){
            System.out.println("num="+num);

            System.out.println(new String(buf,0,num));
            i++;
        }
        System.out.println("i="+i);
    }
    /**
     * 不调用flush();写入不进去
     * 只调用close()方法也会写进去
     * 该目录下有同名文件，则会被覆盖
     */
    @Test
    public void testFileWriter() throws IOException {
        //        FileWriter fw = new FileWriter("file\\cc.txt");
        // 在文件的末尾续写 有同名文件，不覆盖，续写
        FileWriter fw = new FileWriter("file\\cc.txt",true);
        //将字符串写入到流中
        fw.write("大家好\r\n");
        fw.write("小伊伊\r\n");

        fw.flush();
        fw.close();
    }

}
