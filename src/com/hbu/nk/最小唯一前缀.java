package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/ebcf8391390543bfbdd018af60d0c218 <br/>
 * 来源：牛客网<br/>
 * <br/>
 * <p>
 * 给定一组个字符串，为每个字符串找出能够唯一识别该字符串的最小前缀。<br/>
 * <br/>
 * <p>
 * 输入描述:<br/>
 * 第一行输入一个整数 n 表示字符串个数<br/>
 * 后面n行，每行一个字符串，一共n串互不相同的字符串。（2 <= n <= 100，字符串长度不超过100）<br/>
 * <br/>
 * <p>
 * 输出描述:<br/>
 * 输出n行，每行一个字符串，依次是每个字符串的最小可唯一识别前缀<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/22
 */
public class 最小唯一前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ss = new String[n];
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
            res[i] = ss[i];
        }
        //从第一个字符串开始寻找
        for (int j = 0; j < n; j++) {
            //从第一个字符开始寻找最短前缀
            for (int i = 0; i <= ss[j].length(); i++) {
                boolean flg = true;
                //每个字符串寻找一次
                for (String cur : ss) {
                    if (!ss[j].equals(cur) && cur.length() >= i && ss[j].substring(0, i).equals(cur.substring(0, i))) {
                        //匹配上了说明当前长度不够
                        flg = false;
                        break;
                    }
                }
                if (flg) {
                    res[j] = ss[j].substring(0, i);
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}
