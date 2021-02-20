package com.hbu.nk;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 小明是一名算法工程师，同时也是一名铲屎官。某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪的运动信息。<br/>
 * 为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。<br/>
 * 一个猫咪特征是一个两维的vector<x, y>。如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。<br/>
 * 因此，如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，那么它将构成特征运动。<br/>
 * 比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动 2-3-4 和 7-8。<br/>
 * 现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。<br/>
 * <br/>
 * 输入描述:<br/>
 * 第一行包含一个正整数N，代表测试用例的个数。<br/>
 * 每个测试用例的第一行包含一个正整数M，代表视频的帧数。<br/>
 * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；<br/>
 * 比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2><br/>
 * 所有用例的输入特征总数和<100000<br/>
 * N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。<br/>
 * 特征取值均为非负整数。<br/>
 * <br/>
 * 输出描述:<br/>
 * 对每一个测试用例，输出特征运动的长度作为一行<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/20
 */
public class 特征提取 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            HashMap<String, Integer> mem = new HashMap<>();
            HashMap<String, Integer> tempMem = new HashMap<>();
            int m = sc.nextInt();
            int max = 1;
            for (int j = 0; j < m; ++j) {
                tempMem.clear();
                int a = sc.nextInt();
                for (int k = 0; k < a; ++k) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String key = x + " " + y;
                    tempMem.put(key, mem.getOrDefault(key, 0) + 1);
                    max = Math.max(tempMem.get(key), max);
                }
                mem.clear();
                mem.putAll(tempMem);
            }
            System.out.println(Math.max(max, 1));
        }
    }
//1
//8
//2 1 1 2 2
//2 1 1 1 4
//2 1 1 2 2
//2 2 2 1 4
//0
//0
//1 1 1
//1 1 1
}
