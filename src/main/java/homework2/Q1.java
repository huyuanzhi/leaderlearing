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
        String str = "中国";
        byte[] b1 = str.getBytes("UTF-8");
        System.out.println("UTF-8字节内容为:"+b1.toString()+",长度为"+b1.length);
        byte[] b2 = str.getBytes("GBK");
        System.out.println("GBK字节内容为:"+b2.toString()+",长度为"+b2.length);
        byte[] b3 = str.getBytes("ISO-8859-1");
        System.out.println("ISO-8859-1字节内容为:"+b3.toString()+",长度为"+b3.length);
    }
}
