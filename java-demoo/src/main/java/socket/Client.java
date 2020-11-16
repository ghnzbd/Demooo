package socket;

/**
 * @author chaird
 * @create 2020-11-16 14:12
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        // 创建一个socket对象
        Socket socket = new Socket("localhost", 10022);
        // 获得输出流
        OutputStream os = socket.getOutputStream();
        // 写入数据
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名：admin,密码：123");
        pw.flush();

        // 关闭输出流
        socket.shutdownOutput();

        //---->下面是接受服务器发来的响应
        // 从socket中读数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bs = new BufferedReader(isr);
        String str = "";
        while ((str = bs.readLine()) != null) {
            System.out.println("我是客户端，服务器回应说：" + str);
        }

        // 关闭输入流
        socket.shutdownInput();

        // 关闭输入流资源
        bs.close();
        isr.close();
        is.close();

        // 关闭输出流资源
        pw.close();
        os.close();

    }

}