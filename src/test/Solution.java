package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        //排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //判断重叠
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            //将最后区间加入列表
            result.add(new int[]{left, right});
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {

    }
}