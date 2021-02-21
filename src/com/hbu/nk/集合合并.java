package com.hbu.nk;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/c747216a5db24df385392f1a6b90a084 <br/>
 * 来源：牛客网 <br/>
 * <br/>
 * 给定若干个32位int数字集合，每个集合中的数字无重复，譬如：{1,2,3}  {2,5,6}  {8} <br/>
 * 将其中交集不为空的集合合并，保证合并完成后所有集合之间无交集，输出合并后的集合个数以及最大集合中元素的个数。 <br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/21
 */
public class 集合合并 {

    private static Map<Integer, Integer> parent = new HashMap<>();
    private static Map<Integer, Integer> size = new HashMap<>();
    private static Map<Integer, Integer> rank = new HashMap<>();
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] strs = sc.nextLine().split("\\s+");
            int[] arr = new int[strs.length];
            for (int j = 0; j < strs.length; j++) {
                Integer num = Integer.valueOf(strs[j]);
                arr[j] = num;
                parent.putIfAbsent(num, num);
                size.putIfAbsent(num, 1);
                rank.putIfAbsent(num, 1);
            }

            unionSet(arr, 0, arr.length - 1);
        }

        int count = 0;
        for (Integer k : parent.keySet()) {
            if (k.equals(parent.get(k))) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static int unionSet(int[] arr, int start, int end) {
        if (start >= end) {
            return find(arr[start]);
        }

        int mid = start + (end - start) / 2;
        int leftRoot = unionSet(arr, start, mid);
        int rightRoot = unionSet(arr, mid + 1, end);

        return union(leftRoot, rightRoot);
    }

    public static int find(int x) {
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }

        return parent.get(x);
    }

    public static int union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return pRoot;
        }

        if (rank.get(pRoot) < rank.get(qRoot)) {
            parent.put(pRoot, qRoot);
            size.put(qRoot, size.get(pRoot) + size.get(qRoot));
            max = Math.max(max, size.get(qRoot));
            return qRoot;
        } else {
            parent.put(qRoot, pRoot);
            size.put(pRoot, size.get(pRoot) + size.get(qRoot));
            max = Math.max(max, size.get(pRoot));
            if (rank.get(pRoot).equals(rank.get(qRoot))) {
                rank.put(pRoot, rank.get(pRoot) + 1);
            }
            return pRoot;
        }
    }
}