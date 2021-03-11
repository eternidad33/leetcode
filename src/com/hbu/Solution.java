package com.hbu;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                // 1.+，取出一个栈顶元素top
                // 2.将该栈顶元素与取出后的栈顶元素相加得到newTop
                // 3.将top，newTop依次入栈
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("C")) {
                // C，失效，直接出栈
                stack.pop();
            } else if (op.equals("D")) {
                // D，栈顶元素的两倍入栈
                stack.push(2 * stack.peek());
            } else {
                // 数字直接入栈
                stack.push(Integer.valueOf(op));
            }
        }

        // 求栈中所有元素的和
        int sum = 0;
        for (int s : stack) {
            sum += s;
        }
        return sum;
    }

}
