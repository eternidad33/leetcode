package com.hbu.contest;

import java.util.Arrays;

/**
 * @author vigilr
 * @since 2021/02/07
 */
public class 检查数组是否经排序和轮转得到 {
    public boolean check(int[] nums) {
        if (nums == null) {
            return true;
        }

        int[] B = Arrays.copyOf(nums, nums.length);
        Arrays.sort(B);

//        System.out.print("原数组为：");
//        printArrays(nums);
//        System.out.println();
//
//        System.out.print("新数组为：");
//        printArrays(B);
//        System.out.println();

        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                x = i;
                break;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == B[0]) {
////                System.out.println("B[0]的值为"+B[0]);
//                x = i;
//                break;
//            }
//        }

        System.out.println("X的值为：" + x);
        for (int i = 0; i < nums.length; i++) {
            if (B[i] != nums[(i + x) % nums.length]) {
//                System.out.println("i="+i+"时失去匹配");
                return false;
            }
        }
        return true;
    }

    void printArrays(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        检查数组是否经排序和轮转得到 test = new 检查数组是否经排序和轮转得到();
        int[] num1 = {3, 4, 5, 1, 2};
        int[] num2 = {2, 1, 3, 4};
        int[] num3 = {1, 2, 3};
        int[] num4 = {1, 1, 1};
        int[] num5 = {2, 1};
        int[] num6 = {7, 9, 1, 1, 1, 3};
        int[] num7 = {6,10,6};

//        System.out.println(test.check(num1));
        System.out.println(test.check(num7));
//        System.out.println(test.check(num2));
//        System.out.println(test.check(num3));
//        System.out.println(test.check(num4));
//        System.out.println(test.check(num5));
    }
}
