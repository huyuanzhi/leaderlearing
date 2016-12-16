package homework2;


import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

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
        FileOutputStream outputStream1 = new FileOutputStream("d://22.dat");
        outputStream1.write(bigEndian(a));
        FileOutputStream outputStream2 = new FileOutputStream("d://222.dat");
        outputStream2.write(littleEndian(a));

        FileInputStream inputStream = new FileInputStream("d://222.dat");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
        channel.read(buffer);
        byte[] bb = buffer.array();
        System.out.println(littleEndianToInt(bb));
    }

    private static byte[] bigEndian(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xff),
                (byte) ((a >> 16) & 0xff),
                (byte) ((a >> 8) & 0xff),
                (byte) (a & 0xff),
        };
    }

    private static byte[] littleEndian(int a) {
        return new byte[]{
                (byte) (a & 0xff),
                (byte) ((a >> 8) & 0xff),
                (byte) ((a >> 16) & 0xff),
                (byte) ((a >> 24) & 0xff),
        };
    }

    private static int bigEndianToInt(byte[] b) {
        return  (b[3] & 0xff) |
                (b[2] & 0xff) << 8 |
                (b[1] & 0xff) << 16 |
                (b[0] & 0xff) << 24;


    }

    private static int littleEndianToInt(byte[] b) {
        return  (b[0] & 0xff) |
                (b[1] & 0xff) << 8 |
                (b[2] & 0xff) << 16 |
                (b[3] & 0xff) << 24;
    }
}
