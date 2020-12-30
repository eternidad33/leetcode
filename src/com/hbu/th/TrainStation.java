package com.hbu.th;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @author vigilr
 * @since 2020/12/29
 */
public class TrainStation {
    public static int tickets = 20;

    protected synchronized static void sell() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String s = sdf.format(date);
        if (tickets > 0) {
            System.out.println("【" + Thread.currentThread().getName() + "】卖出了第"
                    + tickets-- + "张票，售票时间：" +s);
        }
        if (tickets==0){
            System.out.println("票已售完");
        }
    }

    public static class sellThread implements Runnable {
        @Override
        public void run() {
            while (tickets > 0) {
                try {
                    sell();
                    //随机等待1~3s
                    Random r = new Random();
                    int a = (r.nextInt(3) + 1) * 1000;
                    Thread.sleep(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        sellThread s = new sellThread();
        Thread t1 = new Thread(s, "售票口1");
        Thread t2 = new Thread(s, "售票口2");
        Thread t3 = new Thread(s, "售票口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
