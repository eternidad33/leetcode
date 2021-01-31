package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/01/31
 */
public class 盒子中小球的最大数量 {
    public int countBalls(int lowLimit, int highLimit) {
        //计算highlimit位数
        int n = highLimit, w = 1;
        while (n != 0) {
            n /= 10;
            w++;
        }
        int[] ans = new int[w * 10];
        for (int i = lowLimit; i <= highLimit; i++) {
            //计算i的位数和
            int index = sum_w(i);
            ans[index]++;
        }
        int max = -1;
        for (int i = 0; i < ans.length; i++) {
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public int sum_w(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
