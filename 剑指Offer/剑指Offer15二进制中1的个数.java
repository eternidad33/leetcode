//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 
//9，则该函数输出 2。 
//
// 
//
// 示例 1： 
//
// 
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        //方法1：直接调用Integer中的方法（1ms）
//        System.out.println("'Integer.toBinaryString(n)'转成二进制字符串："+Integer.toBinaryString(n));
//        System.out.println("‘Integer.bitCount(n)'二进制 1 的个数："+Integer.bitCount(n));
//        return Integer.bitCount(n);

        int count = 0;

//        //方法2：逐位判断（1ms）
//        while (n != 0) {
//            //与1进行与运算
//            count += n & 1;
//            // >>>无符号右移
//            n = n >>> 1;
//        }

        //方法3：巧用 n&(n−1)（1ms）
        //(n−1) 解析：二进制数字 n 最右边的 1变成 0，此 1右边的 0 都变成 1。
        //n&(n−1) 解析：二进制数字 n 最右边的 1 变成 0 ，其余不变。
        while (n != 0) {
            count++;
            n &= n - 1;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
