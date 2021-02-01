package com.hbu.reStudy;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(1);
        list.add(23);
        list.add(3);

/*
        //迭代器遍历
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
*/

        //foreach遍历
        for (int l : list) {
            System.out.println(l);
        }
    }
}
