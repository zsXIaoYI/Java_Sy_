package cn.zsza;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        System.out.println(1 >>> 16);

        System.out.println( "Hello World!" );
        System.out.println(System.getProperty("user.dir"));   // 返回E:\IDEA_WorkSpace\Java_Sy_

        System.out.println(File.separator);     // 返回 \
        System.out.println(File.pathSeparator); // 返回 ;


        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        map.put("11","aa");
        map.put("22","bb");
        map.put("33","cc");

        map.get("11");

        map.size();

        System.out.println(map);

        new HashMap<>().put("a","b");

        new HashMap<>().get("a");

        new HashMap<>().remove("");

        new HashSet<>().add("");


        int arr[] = null;
        for (int aa[] = arr;;){
            if (aa == null || aa.length == 0){
                System.out.println(1111);
                aa = new int[]{1, 2};
            }else {
                System.out.println(aa[0]);
            }
        }





    }
}
