package main;

import java.util.*;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            stringBuffer.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        return stringBuffer.reverse().toString();
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //初始化HashMap
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, true);
        }
        //list用于存储哈希表中不存在的元素
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!hashMap.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addStrings("123", "459");
        System.out.println(s);
    }
}