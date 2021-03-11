package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/13483f545ad7499c97a3bbcdcdb9312a <br/>
 * 来源：牛客网 <br/>
 * <br/>
 * 给出一个数字N，对于数字序列 1,2,3 ... N。现在在其中插入“+”, "-", " "，使得表达式的和为M。" "的含义是把相邻的两个数字组成一个数。例如：1 + 2 3 - 4，含义是：1 + 23 - 4 = 20。<br/>
 * 给出N和M，求出所有合法的序列的个数。<br/>
 * <br/>
 * 输入描述:<br/>
 * 两个整数N,M ( 1 <= N <= 7, -100 <= M <= 100)<br/>
 * <br/>
 * 输出描述:<br/>
 * 合法序列的个数<br/>
 * <br/>
 * @author vigilr
 * @since 2021/02/21
 */
public class 如何添加运算符 {
    private static int num;
    private static int target;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        target = scanner.nextInt();
        dfs(0, 1);
        System.out.println(count);
    }

    private static void dfs(int sum, int p) {
        if (sum == target && p == num + 1) {
            count++;
        }
        int t = 0;
        for (int i = p; i <= num; i++, t *= 10) {
            t += i;
            dfs(sum + t, i + 1);
            if (p != 1) {
                dfs(sum - t, i + 1);
            }
        }
    }
}
