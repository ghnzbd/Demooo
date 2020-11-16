package socket;

/**
 * @author chaird
 * @create 2020-11-16 14:13
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

  public static void main(String[] args) throws Exception {
    // 创建一个serverSocket对象,相当于服务器，并且自己设定端口，最好设置1024以后
    ServerSocket serverSocket = new ServerSocket(10022);

   while (true){
     // 调用accept方法监听访问的Socket
     Socket socket = serverSocket.accept();

     // 从socket中读数据
     InputStream is = socket.getInputStream();
     InputStreamReader isr = new InputStreamReader(is);
     BufferedReader bs = new BufferedReader(isr);
     String str = "";
     while ((str = bs.readLine()) != null) {
       System.out.println("我是服务器，客户端说：" + str);
     }

     // 关闭输入流
     socket.shutdownInput();

     // ---->下面是服务器响应客户端
     // 获得输出流
     OutputStream os = socket.getOutputStream();
     // 写入数据
     PrintWriter pw = new PrintWriter(os);
     pw.write("欢迎您：" + new Date().toString());
     pw.flush();

     // 关闭输出流资源
     socket.shutdownOutput();
     pw.close();
     os.close();

     // 关闭输入流资源
     bs.close();
     isr.close();
     is.close();
   }
  }
}
