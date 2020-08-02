package main;

/**
 * @author Vigilr
 * @since 2020-08-02
 */
public class 找出数组游戏的赢家 {
    public int getWinner(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            //比较前两个数
            if (arr[0] > arr[1]) {
                count++;
                //左移
                arr = left(arr, 1);
            } else {
                arr = left(arr, 0);
                count = 1;
            }
            if (count == k) {
                return arr[0];
            }
        }
        return -1;
    }

    public int[] left(int[] arr, int index) {
        int temp = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        找出数组游戏的赢家 m = new 找出数组游戏的赢家();
        int a = m.getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2);
        int b = m.getWinner(new int[]{3,2,1}, 10);
        System.out.println("测试结果1："+a);
    }
}
