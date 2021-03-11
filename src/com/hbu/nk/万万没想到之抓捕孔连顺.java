package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b <br/>
 * 来源：牛客网<br/>
 * <br/>
 * 我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。和我一起行动的还有另外两名特工，我提议<br/>
 * <br/>
 * 1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。<br/>
 * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。<br/>
 * <br/>
 * 我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！<br/>
 * ……<br/>
 * 万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！<br/>
 * <br/>
 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。<br/>
 * 注意：<br/>
 * 1. 两个特工不能埋伏在同一地点<br/>
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用 <br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/20
 */
public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int d = scanner.nextInt();
//        int[] l = new int[n];
//        for (int i = 0; i < n; i++) {
//            l[i] = scanner.nextInt();
//        }
//        solution(n, d, l);


        //==========滑动窗口==========
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int D = in.nextInt();
            int[] location = new int[N];
            for (int i = 0; i < N; i++) {
                location[i] = in.nextInt();
            }
            long count = 0L;

            int right = 2;
            for (int i = 0; i < N - 2; i++) {
                long temp = 0L;
                for (int j = right; j < N; j++) {

                    if (location[j] - location[i] > D) {
                        break;
                    } else {
                        temp = (long) (j - i);
                        right = j;
                    }

                }
                if (temp >= 2) {
                    count += temp * (temp - 1) / 2 % 99997867;
                }
            }
            System.out.println(count % 99997867);
        }
    }

    public static void solution(int n, int d, int[] l) {
        if (n < 3) {
            return;
        }
        int res = 0, left = 0, right = 2;
        while (left < (n - 2)) {
            while (right < n && l[right] - l[left] <= d) {
                right += 1;
            }

            int temp = right - left - 1;
            if (temp >= 2) {
                res += temp * (temp - 1) / 2 % 99997867;
            }
            left += 1;
        }
        System.out.println(res % 99997867);
    }
}
