package com.hbu.reStudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author vigilr
 * @since 2021/02/01
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "zahngsan");
        map.put(4, "lisi");
        map.put(5, "王五");
        map.put(3, "张三");
        //哈希表长度
        System.out.println("哈希表长度为：" + map.size());
        //取key为2的元素
        System.out.println("key值为2对应的value为：" + map.get(2));
        //遍历
        //方法1：获取所有的key
        System.out.println("==============");
        System.out.println("通过获取所有的key遍历");
        Set<Integer> set = map.keySet();
        for (int i : set) {
            System.out.println(map.get(i));
        }
        //方法2：通过Map.Entry遍历
        System.out.println("==============");
        System.out.println("通过Map.Entry遍历");
        Set<Map.Entry<Integer, String>> nodes = map.entrySet();
        for (Map.Entry<Integer, String> node : nodes) {
            System.out.println(node.getKey() + "=" + node.getValue());
        }
    }
}
