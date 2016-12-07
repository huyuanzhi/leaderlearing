package homework2;

import java.io.*;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/7
 * @project: leaderlearing
 * @packageName: homework2
 * @description: XXXXXX
 */
public class Q2 {

    public static void main(String[] args) throws Exception {
        int a = 10240;
        FileOutputStream outputStream = new FileOutputStream(new File("d://q2.dat"));
        System.out.println(Integer.toBinaryString(a).getBytes().length);
        outputStream.write(Integer.toBinaryString(a).getBytes());
    }
}
