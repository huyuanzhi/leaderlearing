package homework2;

import java.io.UnsupportedEncodingException;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/7
 * @project: leaderlearing
 * @packageName: homework2
 * @description: XXXXXX
 */
public class Q1 {

    public static void main(String[] args) throws Exception {
        String str = "??";
        byte[] b1 = str.getBytes("UTF-8");
        System.out.println("UTF-8?????:"+b1.toString()+",???"+b1.length);
        byte[] b2 = str.getBytes("GBK");
        System.out.println("GBK?????:"+b2.toString()+",???"+b2.length);
        byte[] b3 = str.getBytes("ISO-8859-1");
        System.out.println("ISO-8859-1?????:"+b3.toString()+",???"+b3.length);
    }
}
