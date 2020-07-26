package niodemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * @author chaird
 * @create 2020-07-26 20:10
 */
public class ClientDemo {
  public static void main(String[] args) throws Exception {

    // 获取通道
    SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8081));
    // 切换非阻塞模式
    socketChannel.configureBlocking(false);

    // 分配指定大小缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 发送数据
    buffer.put(new Date().toString().getBytes());
    buffer.flip();
    socketChannel.write(buffer);
    buffer.clear();

    // 关闭通道
    socketChannel.close();
  }
}
