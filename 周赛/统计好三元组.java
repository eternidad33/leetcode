package main;

/**
 * @author Vigilr
 * @since 2020-08-02
 */
public class 统计好三元组 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        统计好三元组 m = new 统计好三元组();
        int a = m.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3);
        int b = m.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1);
        System.out.println("测试结果1：" + a);
        System.out.println("测试结果2：" + b);
    }
}
