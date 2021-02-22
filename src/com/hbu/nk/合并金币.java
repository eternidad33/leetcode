package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/6d3ccbc5b6ad4f12b8fe4c97eaf969e0 <br/>
 * 来源：牛客网 <br/>
 * <br/>
 *
 *  有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，
 *  成本为这两堆金币块数之和。经过N-1次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。<br/>
 * 其中，1 <= N <= 30，1 <= C[i] <= 100<br/>
 * <br/>
 *
 * 输入描述:<br/>
 * 第一行输入一个数字 N 表示有 N 堆金币<br/>
 * 第二行输入 N 个数字表示每堆金币的数量 C[i]<br/>
 * <br/>
 *
 * 输出描述:<br/>
 * 输出一个数字 S 表示最小的合并成一堆的成本<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/22
 */
public class 合并金币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            money[i] = sc.nextInt();
            if (i == 1) {
                preSum[i] = money[i];
            } else {
                preSum[i] = preSum[i - 1] + money[i];
            }
        }
        sc.close();

        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = preSum[j] - preSum[i - 1];
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
