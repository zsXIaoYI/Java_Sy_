package cn.zsza;

import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        System.out.println(System.getProperty("user.dir"));   // 返回E:\IDEA_WorkSpace\Java_Sy_

        System.out.println(File.separator);     // 返回 \
        System.out.println(File.pathSeparator); // 返回 ;

    }
}
