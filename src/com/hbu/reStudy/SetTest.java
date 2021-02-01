package com.hbu.reStudy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vigilr
 * @since 2021/02/01
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Student s1 = new Student("张三", 12);
        Student s2 = new Student("李四", 11);
        Student s3 = new Student("张三", 12);
        Student s4 = new Student("王五", 12);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println(students.size());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;

        if (getAge() != student.getAge()) {
            return false;
        }
        return getName() != null ? getName().equals(student.getName()) : student.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
