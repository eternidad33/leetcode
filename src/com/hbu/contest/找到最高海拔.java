package com.hbu.contest;

/**
 * @author vigilr
 * @since 2021/01/23
 */
public class 找到最高海拔 {
    public int largestAltitude(int[] gain) {
        //存储每个点的海拔高度
        int[] heights = new int[gain.length + 1];
        heights[0] = 0;
        //max存储海拔高度的最大值
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            heights[i + 1] = heights[i] + gain[i];
            max = Math.max(max, heights[i + 1]);
        }
        return max;
    }
}
