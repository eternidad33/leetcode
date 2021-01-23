package com.hbu.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vigilr
 * @since 2021/01/23
 */
public class 需要教语言的最少人数 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<int[]> ship = new ArrayList<>();
        for (int[] friendship : friendships) {
            //朋友是否有共同语言
            if (hasSameLanguage(languages[friendship[0]], languages[friendship[1]])) {
                continue;
            }
            //没有共同语言,记录两个朋友关系
            ship.add(friendship);
        }
        if (ship.size() == 0) {
            return 0;
        }
        //取出一对关系
        //需要教的语言必在两个人会的语言合集中
        ArrayList<Integer> langs = new ArrayList<>();
        int[] temp = ship.get(0);
        for (int l : languages[temp[0]]) {
            langs.add(l);
        }
        for (int l : languages[temp[1]]) {
            langs.add(l);
        }

        int count = 1;
        //分别记录每种语言是否适合教，计算要教多少人
        for (int i = 0; i < langs.size(); i++) {
            int tmp = langs.get(i);
            int tc = 1;
            for (int j = 1; j < ship.size(); j++) {
                //判断教会tmp
                int[] s = ship.get(j);
                if (!hasNum(tmp, languages[s[0]])) {
                    tc++;
                }
                if (!hasNum(tmp, languages[s[1]])) {
                    tc++;
                }
            }
            count = Math.min(count, tc);
        }


        return count;
    }

    /**
     * 是否有共同语言
     *
     *@param lang1 数组1
     *@param lang2 数组2
     *@return boolean
    */
    public boolean hasSameLanguage(int[] lang1, int[] lang2) {
        for (int i = 0; i < lang1.length; i++) {
            for (int j = 0; j < lang2.length; j++) {
                if (lang1[i] == lang2[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断num是否在nums数组中
     *
     *@param num 要判断的数
     *@param nums 数组
     *@return boolean
    */
    public boolean hasNum(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
