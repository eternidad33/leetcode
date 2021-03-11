package com.hbu.nk;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92 <br/>
 * 来源：牛客网<br/>
 * <br/>
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello<br/>
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello<br/>
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC <br/>
 * <br/>
 * @author vigilr
 * @since 2021/02/20
 */
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        //方法1：正则表达式
        Scanner scanner=new Scanner(System.in);
        int line=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<line;i++){
            // replaceAll("(.)\\1+","$1$1")把3个以上的字符换成2个
            // replaceAll("(.)\\1(.)\\2","$1$1$2")把AABB型换成AAB型
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+","$1$1")
                    .replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }


    }
}
