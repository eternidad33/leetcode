//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public int[] printNumbers(int n) {
//        // 方法1：直接算
//        if (n == 0) {
//            return new int[0];
//        }
//        int limit = (int) Math.pow(10, n);
//        int[] result = new int[limit - 1];
//        for (int i = 1; i < limit; i++) {
//            result[i - 1] = i;
//        }
//        return result;

        //方法2：考虑大数越界情况(9ms)
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
