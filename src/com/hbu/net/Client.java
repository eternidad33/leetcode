package com.hbu.net;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author vigilr
 * @since 2020/12/31
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.建立连接
        Socket socket=new Socket("127.0.0.1",10086);

        //2.网络输出流
        OutputStream os=socket.getOutputStream();
        os.write("你好服务器！".getBytes(StandardCharsets.UTF_8));

        //3.网络输入流
        InputStream is=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //4.释放资源
        socket.close();

    }
}
