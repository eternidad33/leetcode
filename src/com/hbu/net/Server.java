package com.hbu.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
*@author vigilr
*@since 2020/12/31
*/
public class Server extends Thread{
    public static void main(String[] args) throws IOException {
        //1.建立服务器
        ServerSocket serverSocket=new ServerSocket(10086);
        System.out.println("等待客户端连接。。。");

        //2.获取请求对象的Socket
        Socket socket=serverSocket.accept();
        System.out.println("连接成功");

        //3.获取网络字节输入流
        InputStream is=socket.getInputStream();

        //4.InputStream的read方法读取数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //5.网络输出流，回写
        OutputStream os=socket.getOutputStream();
        os.write("收到".getBytes(StandardCharsets.UTF_8));

        //6.释放资源
        socket.close();
        serverSocket.close();
    }
}

