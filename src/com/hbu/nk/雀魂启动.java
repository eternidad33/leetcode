package com.hbu.nk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/448127caa21e462f9c9755589a8f2416 <br/>
 * 来源：牛客网<br/>
 * <br/>
 * 总共有36张牌，每张牌是1~9。每个数字4张牌。你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌<br/>
 * 1、14张牌中有2张相同数字的牌，称为雀头。<br/>
 * 2、除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）<br/>
 * <br/>
 * 输入描述:<br/>
 * 输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。<br/>
 * 输出描述:<br/>
 * 输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/20
 */
public class 雀魂启动 {

    private static boolean canHu(int[] arr, int total, boolean hasHead) {
        if (total == 0) {
            return true;
        }
        //没有雀头
        if (!hasHead) {
            for (int i = 0; i < 9; i++) {
                //取出牌数大于2的牌作为雀头
                if (arr[i] >= 2) {
                    arr[i] -= 2;
                    if (canHu(arr, total - 2, true)) {
                        return true;
                    }
                    arr[i] += 2;
                }
            }
            return false;
        } else {
            //有雀头
            for (int i = 0; i < 9; i++) {
                if (arr[i] > 0) {
                    //取出三个相同的牌
                    if (arr[i] >= 3) {
                        arr[i] -= 3;
                        if (canHu(arr, total - 3, true)) {
                            return true;
                        }
                        arr[i] += 3;
                    }
                    //取出三张连续的牌判断
                    if (i + 2 < 9 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                        arr[i]--;
                        arr[i + 1]--;
                        arr[i + 2]--;
                        if (canHu(arr, total - 3, true)) {
                            return true;
                        }
                        arr[i]++;
                        arr[i + 1]++;
                        arr[i + 2]++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //存储手中的牌数字对应的个数
        int[] state = new int[9], helpArr = new int[9];
        //存储结果
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();
            state[num - 1]++;
        }

        for (int i = 0; i < 9; i++) {
            if (state[i] < 4) {
                int num = i + 1;
                System.arraycopy(state, 0, helpArr, 0, 9);
                helpArr[i]++;
                //判断新数组是否可以胡牌
                if (canHu(helpArr, 14, false)) {
                    res.add(num);
                }
            }
        }

        if (res.isEmpty()) {
            System.out.println(0);
        } else {
            //用StringBuilder存储结果
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                stringBuilder.append(" ");
                stringBuilder.append(res.get(i));
            }
            System.out.println(stringBuilder.toString());
        }
    }

    //1 1 1 1 2 2 3 3 5 6 7 8 9
}
