package com.hbu.nk;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * 定义：数值序列中包含2~16进制整数，如果序列中有一个数，与序列中其他任何一个数大小都不相等，则这个数叫做“异数”。请找出给定数值序列中所有的“异数”.<br/>
 * <br/>
 * 输入描述:<br/>
 * 输入数值序列i行（0< i），每一行分别是进制和数值，以“#”分割。如：n#m, n是整数，代表n进制（1 < n < 17）,m是n进制下的数值.<br/>
 * 输入序列以结束符”END”结束。<br/>
 * m的字符集为0-9和A-F，保证数值在十进制下不超过1e9，行数不超过100001行。<br/>
 * <br/>
 * <p>
 * 输出描述:<br/>
 * 输出j行(0 < j <= i),每一行都是输入序列的“异数”。要求：<br/>
 * 1.按照输入序列的原序输出;<br/>
 * 2.如果没有”异数”,输出字符串”None”<br/>
 * 3.结束符“END”不用输出<br/>
 * <br/>
 *
 * @author vigilr
 * @since 2021/02/21
 */
public class 找异数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> mapCount = new LinkedHashMap<>();
        HashMap<Integer, String> mapRes = new HashMap<>();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if ("END".equals(str)) {
                break;
            }

            String[] a = str.split("#");
            int num = Integer.parseInt(a[1], Integer.parseInt(a[0]));
            mapRes.put(num, str);
            mapCount.put(num, mapCount.getOrDefault(num, 0) + 1);
        }
        scanner.close();
        boolean flag = false;
        for (int key : mapCount.keySet()) {
            if (mapCount.get(key) == 1) {
                flag = true;
                System.out.println(mapRes.get(key));
            }
        }
        if (!flag) {
            System.out.println("None");
        }

    }
}
