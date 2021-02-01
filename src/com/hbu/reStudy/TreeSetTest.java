package com.hbu.reStudy;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author vigilr
 * @since 2021/02/01
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //匿名内部类实现降序
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ts.add(123);
        ts.add(12);
        ts.add(13);
        ts.add(13);
        ts.add(1);
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("================");
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        students.add(new Student("张三", 3));
        students.add(new Student("马六", 6));
        students.add(new Student("王五", 5));
        students.add(new Student("李四", 4));
        students.add(new Student("张三", 3));
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("=============");
        TreeSet<AAAA> aaaas = new TreeSet<>();
        aaaas.add(new AAAA(123));
        aaaas.add(new AAAA(13));
        aaaas.add(new AAAA(1));
        aaaas.add(new AAAA(12));
        aaaas.add(new AAAA(123));
        for (AAAA aaaa : aaaas) {
            System.out.println(aaaa);
        }

    }
}

class AAAA implements Comparable<AAAA> {
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "AAAA{" +
                "i=" + i +
                '}';
    }

    public AAAA(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(AAAA o) {
        //升序this.i - o.i
        //降序
        return o.i - this.i;
    }
}