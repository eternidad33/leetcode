package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/dbec58daf75149e096fcd359e536d5cd <br/>
 * 来源：牛客网 <br/>
 * <br/>
 * 在米兔生活的二维世界中，建造蓄水池非常简单。<br/>
 * 一个蓄水池可以用n个坐标轴上的非负整数表示，代表区间为【0-n】范围内宽度为1的墙壁的高度。<br/>
 * 如下图1，黑色部分是墙壁，墙壁的高度是[0,1,0,2,1,0,1,3,2,1,2,1] ，蓝色部分是蓄水的面积，可以看出蓄水池最大蓄水容量是6。<br/>
 * 现在米兔想通过增加某些墙壁的高度对蓄水池扩容，但是经费有限，最多只能增加最多m的高度，增加高度只能在【0-n】范围内，高度为0的区域也是可以增加的，为了追求最大的性价比，米兔想要找到一种最优方案，使扩容后蓄水池的容量最大，你能帮帮他么？<br/>
 * <br/>
 * 输入描述:<br/>
 * 第一行为一个数字n <br/>
 * 接下来n行，每行一个数字，代表n个墙壁的高度<br/>
 * 最后一行为一个数字m<br/>
 * <br/>
 * 输出描述:<br/>
 * 一个数字，表示扩容之后蓄水池能达到的最大容量<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/21
 */
public class 升级蓄水池 {

    static int maxHeightAns;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int capacity = calcCapacity(heights);
        int maxHeight = 0, maxidx = -1;
        for (int i = 0; i < n; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxidx = i;
            }
        }
        find(heights, 0, m, n);
        System.out.println(maxHeightAns);
    }

    private static void find(int[] heights, int index, int m, int n) {
        if (index == n) {
            return;
        }
        if (0 == m) {
            maxHeightAns = Math.max(maxHeightAns, calcCapacity(heights));
            return;
        }
        for (int j = 0; j <= m; j++) {
            heights[index] += j;
            find(heights, index + 1, m - j, n);
            heights[index] -= j;
        }
    }

    private static int calcCapacity(int[] heights) {
        int water = 0;
        int peakIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > heights[peakIndex]) {
                peakIndex = i;
            }
        }
        for (int i = 0, leftPeak = 0; i < peakIndex; i++) {
            if (heights[i] > leftPeak) {
                leftPeak = heights[i];
            } else {
                water += leftPeak - heights[i];
            }
        }
        for (int i = heights.length - 1, rightPeak = 0; i > peakIndex; i--) {
            if (heights[i] > rightPeak) {
                rightPeak = heights[i];
            } else {
                water += rightPeak - heights[i];
            }
        }
        return water;
    }
}
