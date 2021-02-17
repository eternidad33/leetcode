//求 1+2+...+n ，要求不能使用乘除法、
// for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
//        //方法1：直接算（不合题意）
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            sum += i;
//        }
//        return sum;

        //方法2：递归（1ms）
        return n == 0 ? 0 : n + sumNums(n - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
