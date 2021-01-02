package com.hbu.hf;

import java.util.Scanner;

/**
 * @author vigilr
 * @since 2020/12/30
 */
public class MatrixUtil {
    /**
     * 输入矩阵
     *
     * @param n 矩阵阶数
     * @return int[][]
     */
    public static int[][] inputMatrix(int n) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[n][n];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("输入有误请重新输入！");
            matrix = inputMatrix(n);
        }
        return matrix;
    }

    /**
     * 判断是否为幻方矩阵
     */
    public static boolean isMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += matrix[0][j];
        }
        //判断行是否相等
        for (int[] value : matrix) {
            int row_sum = 0;
            for (int j = 0; j < n; j++) {
                row_sum += value[j];
            }
            if (row_sum != sum) {
                return false;
            }
        }
        //判断列是否相等
        for (int i = 0; i < n; i++) {
            int col_sum = 0;
            for (int[] ints : matrix) {
                col_sum += ints[i];
            }
            if (col_sum != sum) {
                return false;
            }
        }
        //判断对角线是否相等
        //主对角线和副对角线都初始化为0
        int mainDiag_sum = 0, subDiag_sum = 0;
        for (int i = 0; i < n; i++) {
            mainDiag_sum += matrix[i][i];
            subDiag_sum += matrix[i][n - 1 - i];
        }
        if (mainDiag_sum != sum || subDiag_sum != sum) {
            return false;
        }
        return true;
    }
}
