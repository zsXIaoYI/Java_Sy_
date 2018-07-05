package cn.zsza.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by user on 2016/3/6.
 * 字节流
 */
public class CopyPicByInputStream {

    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        /**
         * 关于输入输出流，1.JPG要把自己的流对象输入给程序，所以用输入流
         *     而程序要把上述的输入流给copy.JPG，所以要用输出流
         */
        try {
            fis = new FileInputStream("file\\1.JPG");         //访问1.jpg
            fos = new FileOutputStream("file\\copy.JPG");
            byte buf[] = new byte[1024];

            System.out.println(fis.available());
            int num;
            while((num=fis.read(buf))!=-1){
                fos.write(buf, 0, num);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fis!=null)
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
        }
    }

    /**
     * 使用BufferedInputStream拷贝图片
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("file\\1.jpg"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("file\\2.jpg"));

        int by;
        int count = 0;
        while((by=bufis.read())!=-1) {
            count++;
            bufos.write(by);
        }
        System.out.println("count="+count);
        bufos.close();
        bufis.close();
    }


}

