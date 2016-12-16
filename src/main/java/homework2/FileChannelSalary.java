package homework2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/16
 * @project: leaderlearing
 * @packageName: homework2
 * @description: XXXXXX
 */
public class FileChannelSalary {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("d://q3.dat"));
        FileChannel channel = inputStream.getChannel();
        MappedByteBuffer buffer =channel.map(FileChannel.MapMode.READ_WRITE,0,channel.size());
        buffer.putInt(12);
    }

}
