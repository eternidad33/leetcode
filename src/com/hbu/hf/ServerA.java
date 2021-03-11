package com.hbu.hf;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author vigilr
 * @since 2020/12/30
 */
public class ServerA extends Thread {
    public ServerSocket server;
    public Socket socket;
    public Scanner scanner;

    /**
     * 服务器<br/>
     * 实验步骤：<br/>
     * 1.建立服务器<br/>
     * 2.监听客户端连接<br/>
     * 3.获取网络输入流<br/>
     * 4.判断是否为幻方矩阵<br/>
     * 5.将结果传回客户端<br/>
     * 6.释放资源<br/>
     *
     * @param args 主程序参数
     * @return void
     */
    public static void main(String[] args) throws IOException {
        ServerA serverA = new ServerA();
        serverA.start();
    }

    public ServerA() {
        try {
            server = new ServerSocket(10086);
            System.out.println("等待连接");
            socket = server.accept();
            System.out.println("有客户端连接，IP为" + socket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放资源
     */
    public void socketClose() {
        try {
            scanner.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送数据
     */
    public synchronized void sendData(String s) {
        try {
            OutputStream os = socket.getOutputStream();
            os.write(s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
            byte[] bytes = new byte[100];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取int类型的值
     */
    public int getOrder() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
            byte[] bytes = new byte[100];
            int len;
            StringBuilder sb = new StringBuilder();
            if ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            return Integer.getInteger(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 显示客户端输入的输入的矩阵
     */
    public void displayMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = getOrder();
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
//        sendData("欢迎连接本服务器");
//        int n = getOrder();
//        System.out.println(n);


//        int[][] matrix = new int[n][n];
//        displayMatrix(matrix,n);

//        scanner.nextInt();
        //释放资源
//        socketClose();
        System.out.println("用户输入的矩阵为：");
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        for (int[] value : m1) {
            for (int v : value) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println("用户输入的矩阵为：");
        for (int[] value : m2) {
            for (int v : value) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
