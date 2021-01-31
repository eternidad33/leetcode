package com.hbu.contest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author vigilr
 * @since 2021/01/31
 */
public class 从相邻元素对还原数组 {
    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs == null || adjacentPairs.length == 0 || adjacentPairs[0].length == 0) {
            return new int[0];
        }
        //原数组长度为相邻接点数组长度+1
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        //只有边上的元素出现一次
        //找出边上的元素

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            if (map.containsKey(adj[0])) {
                map.put(adj[1], adj[0]);
                map2.put(adj[0], adj[1]);
            } else {
                map.put(adj[0], adj[1]);
                map2.put(adj[1], adj[0]);
            }
            if (!mapCount.containsKey(adj[0])) {
                mapCount.put(adj[0], 1);
            } else {
                int temp = mapCount.get(adj[0]);
                mapCount.put(adj[0], temp + 1);
            }
            if (!mapCount.containsKey(adj[1])) {
                mapCount.put(adj[1], 1);
            } else {
                int temp2 = mapCount.get(adj[1]);
                mapCount.put(adj[1], temp2 + 1);
            }
        }
        Collection c = mapCount.values();
        Iterator it = c.iterator();
        //每个点出现的次数
        int ec = 0;
        //存储边界点
        int edge = 0;
        while (it.hasNext()) {
            ec = (int) it.next();
            System.out.println("ec的值为" + ec);
            //奇数为边界
            if ((ec & 1) == 1) {
                break;
            }
        }
        for (Map.Entry<Integer, Integer> mapEntry : mapCount.entrySet()) {
            if (mapEntry.getValue().equals(ec)) {
                edge = mapEntry.getKey();
                System.out.println("查到边界值edge：" + edge);
                break;
            }
        }
        res[0] = edge;
        for (int i = 1; i < n; i++) {
            System.out.println("i的值为" + i);
            if (map.containsKey(res[i - 1])) {
                res[i] = map.get(res[i - 1]);
            } else {
                res[i] = map2.get(res[i - 1]);
            }
        }
        return res;
    }
}
