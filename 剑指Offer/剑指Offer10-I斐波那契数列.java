//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
// 斐波那契数列的定义如下：
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
//        // 方法1：递归（超时）
//        if (n < 2) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);

        //方法2 动态规划
        // 注意：大数越界，随着n增大，f(n)会超过Int32甚至Int64的取值范围，
        // 导致最终的返回值错误。
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
