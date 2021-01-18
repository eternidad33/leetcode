//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 143 👎 0

import Math

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
//        //方法1：数学+贪心(0ms)
//        if (n <= 3) {
//            return n - 1;
//        }
//        int a = n / 3, b = n % 3;
//        if (b == 0) {
//            return (int) Math.pow(3, a);
//        }
//        if (b == 1) {
//            return (int) Math.pow(3, a - 1) * 4;
//        }
//        return (int) Math.pow(3, a) * 2;

        //方法2：动态规划(0ms)
        if (n <= 3) {
            return n - 1;
        }

        int[] p = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            p[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = p[j] * p[i - j];
                if (temp > max) {
                    max = temp;
                }
                p[i] = max;
            }
        }
        return p[n];

//        //方法3：贪心(0ms)
//        if (n <= 3) {
//            return n - 1;
//        }
//
//        //尽可能多的剪去长度为3的长度
//        int n3 = n / 3;
//
//        //剩余长度为4，可剪成两个长度为2
//        if (n % 3 == 1) {
////        if (n - n3 * 3 == 1) {
//            n3--;
//        }
//        int n2 = (n - n3 * 3) / 2;
//        return (int) Math.pow(3, n3) * (int) Math.pow(2, n2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
