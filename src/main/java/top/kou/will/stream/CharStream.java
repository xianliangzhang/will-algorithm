package top.kou.will.stream;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2017/3/7.
 */
public class CharStream {
    public static void main(String[] args) throws Exception  {

        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("x"), "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate("xxx".getBytes().length);
        channel.write(byteBuffer);
    }
}
