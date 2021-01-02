package com.hbu.hf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author vigilr
 * @since 2020/12/30
 */
public class ClientA extends Thread {
    public Socket socket;
    public static String host = "localhost";
    public static int port = 10086;

    /**
     * 客户端<br/>
     * <br/>
     * 实验步骤：<br/>
     * 1.建立与服务器连接<br/>
     * 2.本地输入矩阵<br/>
     * 3.通过网络输出流将矩阵输出<br/>
     * 4.网络输入流接收幻方结果<br/>
     * 5.选择是否悔棋<br/>
     * 6.释放资源<br/>
     * <br/>
     * <br/>
     *
     * @param args 主程序参数
     * @return void
     */
    public static void main(String[] args) throws IOException {
        ClientA client = new ClientA();
        client.start();
    }


    /**
     * 连接服务器
     */
    public ClientA() {
        try {
            socket = new Socket(host, port);
            System.out.println("连接服务器成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 断开连接
     */
    public void socketClose() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 网络输出流，输出int类型数据
     */
    public synchronized void sendData(int n) {
        try {
            OutputStream os = socket.getOutputStream();
            String s = Integer.toString(n);
            os.write(s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据
     */
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

    @Override
    public void run() {
        getData();
        System.out.println("请输入矩阵阶数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //发送阶数n
//        sendData(n);

        int a = 1;
        while (a == 1) {
            System.out.println("请输入矩阵：");
            int[][] matrix = MatrixUtil.inputMatrix(n);
            boolean flag = MatrixUtil.isMagicSquare(matrix);
            if (flag) {
                System.out.println("是幻方");
                a = 2;
            } else {
                System.out.println("不是幻方，是否重新输入");
                System.out.println("1.是");
                System.out.println("2.否");
                a = sc.nextInt();
            }
        }

        //释放资源
        sc.close();
        socketClose();
    }
}
