package com.hbu.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vigilr
 * @since 2021/01/23
 */
public class 需要教语言的最少人数 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        //两个集合，分别存储每种语言已经会的人，每种语言需要教的人
        Set[] learned = new HashSet[n + 1];
        Set[] needTeach = new HashSet[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            learned[i] = new HashSet();
            needTeach[i] = new HashSet();
        }

        //找出每种语言哪些人已经学会了
        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                learned[languages[i][j]].add(i + 1);
            }
        }

        //核心代码
        //遍历朋友关系
        out:
        for (int i = 0; i < friendships.length; i++) {
            for (int j = 1; j < learned.length; j++) {
                //如果两个人已经可以交流，不需要再教，跳过
                //两个人都会j语言不需要再教，回到外层循环
                if (learned[j].contains(friendships[i][0]) && learned[j].contains(friendships[i][1])) {
                    continue out;
                }
            }
            //不能交流，需要学习新语言
            for (int j = 1; j < learned.length; j++) {
                if (!learned[j].contains(friendships[i][0])) {
                    needTeach[j].add(friendships[i][0]);
                }
                if (!learned[j].contains(friendships[i][1])) {
                    needTeach[j].add(friendships[i][1]);
                }
            }

        }
        //找出最小值
        for (int i = 1; i < needTeach.length; i++) {
            min = Math.min(min, needTeach[i].size());
        }
        return min;
    }
}
