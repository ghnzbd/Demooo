package niodemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author chaird
 * @create 2020-07-26 20:15
 */
public class ServerDemo {
  public static void main(String[] args) throws Exception {

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    serverSocketChannel.configureBlocking(false);

    serverSocketChannel.bind(new InetSocketAddress(8081));

    Selector selector = Selector.open();

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    while (selector.select() > 0) {
      Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
      while (iterator.hasNext()) {
        SelectionKey next = iterator.next();
        if (next.isAcceptable()) {
          SocketChannel socketChannel = serverSocketChannel.accept();

          socketChannel.configureBlocking(false);

          socketChannel.register(selector, SelectionKey.OP_READ);

        } else if (next.isReadable()) {

          SocketChannel socketChannel = (SocketChannel) next.channel();

          // 分配指定大小缓冲区
          ByteBuffer buffer = ByteBuffer.allocate(1024);
          int len = 0;
          while ((len = socketChannel.read(buffer)) > 0) {

            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
          }
        }
        iterator.remove();
      }
    }
  }
}
