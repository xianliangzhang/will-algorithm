package top.kou.will.stream;

import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2017/3/7.
 */
public class ByteStream {
    static final String MESSAGE = "Hello java!";


    static final void printBufferInformation(Buffer buffer) {
        String format = String.format("CharBuffer[position=%d, limit=%d, capacity=%d]", buffer.position(), buffer.limit(), buffer.capacity());
        System.out.println(format);
    }

    static void testFileChannel() throws Exception {
        FileOutputStream in = new FileOutputStream("xx");
        FileChannel channel = in.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(8);
        printBufferInformation(buffer);

        for (int i = 0; i < MESSAGE.getBytes().length; i ++) {
            buffer.put(MESSAGE.getBytes()[i]);
            printBufferInformation(buffer);

            if (buffer.position() == buffer.limit() || i == MESSAGE.getBytes().length - 1) {
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
        }
    }

    static void testSocketChannel() throws Exception {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("148.251.188.73", 80));

        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);
        buffer.flip();
        System.out.println(buffer.position());
        buffer.clear();

        channel.close();

    }

    static class ServerSocketChannelThread extends Thread {
        @Override
        public void run() {
            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.socket().bind(new InetSocketAddress(2222));
                SocketChannel clientChanel = channel.accept();

                ByteBuffer buffer = ByteBuffer.allocate(128);
                clientChanel.read(buffer);
                buffer.flip();
                System.out.println(new String(buffer.array(), "utf8"));
                buffer.clear();

                buffer.put("response".getBytes());
                buffer.flip();
                clientChanel.write(buffer);
                clientChanel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class SocketChannelThread extends Thread {
        @Override
        public void run() {
            try {
                SocketChannel channel = SocketChannel.open();
                channel.connect(new InetSocketAddress("localhost", 2222));

                ByteBuffer buffer = ByteBuffer.allocate(128);
                buffer.put("request".getBytes());
                buffer.flip();
                channel.write(buffer);
                buffer.clear();

                channel.read(buffer);
                buffer.flip();
                System.out.println(new String(buffer.array(), "utf8"));
                buffer.clear();

                channel.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ServerSocketChannelThread().start();
        new SocketChannelThread().start();
    }

}
