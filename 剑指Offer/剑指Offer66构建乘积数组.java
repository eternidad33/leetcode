//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
// 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
// 不能使用除法。
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 79 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
//        //方法1：直接法（不能使用除法，不合题意）
//        if (a == null || a.length == 0) {
//            return new int[0];
//        }
//        int f = 1;
//        //记录0的个数
//        int count = 0, index=-1;
//        //先计算所有数的乘积
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == 0) {
//                count++;
//                index = i;
//            }
//            f *= a[i];
//        }
//        //初始化b数组
//        int[] b = new int[a.length];
//
//        if (f == 0 && count > 1) {
//            return b;
//        }
//
//        if (count == 1) {
//            int f2 = 1;
//            for (int i = 0; i < index; i++) {
//                f2 *= a[i];
//            }
//            for (int i = index + 1; i < a.length; i++) {
//                f2 *= a[i];
//            }
//            b[index] = f2;
//            return b;
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            b[i] = f / a[i];
//        }
//        return b;

        //方法2：构建矩阵
        if (a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;

        for (int i = 1; i < a.length; i++) {
            //下三角乘积
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            //上三角乘积
            tmp *= a[i + 1];
            //下三角*上三角
            b[i] *= tmp;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
