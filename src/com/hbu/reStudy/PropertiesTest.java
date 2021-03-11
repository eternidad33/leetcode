package com.hbu.reStudy;

import java.util.Properties;

/**
 * @author vigilr
 * @since 2021/02/01
 */
public class PropertiesTest {
    public static void main(String[] args) {
        //创建对象
        Properties pro = new Properties();
        //存
        pro.setProperty("username", "zhangsan");
        pro.setProperty("password", "123456");
        //取
        String name = pro.getProperty("username");
        String password = pro.getProperty("password");
        System.out.println(name);
        System.out.println(password);
    }
}
