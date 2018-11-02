package cn.zsza.io;

import org.junit.Test;
import java.io.*;

/**
 * @Author: ZhangSong
 * @Date: 2018/6/20 13:48
 * @Company: NoNo
 */
public class BufferedReaderAndWriter {
    /**
     * BufferedReader 支持一行一行地读
     * @throws IOException
     */
    @Test
    public void testBufferedReader() throws IOException {
        FileReader fr = new FileReader("file\\dd.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line=br.readLine())!=null){
            System.out.println("line="+line);
        }
        br.close();
    }
    @Test
    public void testBufferedWriter() throws IOException {
        // 创建一个字符写入流对象
        FileWriter fw = new FileWriter("file\\dd.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 3; i++) {
            bw.write("我是小xx");
            bw.newLine();
            bw.flush();      // 记住刷新
        }
        bw.close();     //把流对象也关闭了。
    }
}
