//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
// 输入n，打印出s的所有可能的值出现的概率。
//
// 
//
// 你需要用一个浮点数数组返回答案，
// 其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,
//      0.13889,0.11111,0.08333,0.05556,0.02778]
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 166 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[12][70];
        //初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                //初始化k值
                //初始化dp[i-1][j-1],用于后续累加
                int k = 1;
                int temp = dp[i - 1][j - k];
                //计算dp[i-1][j-1]+dp[i-1][j-2]+....dp[i-1][j-k],k∈[1,6]且j-k>=1
                while (k <= 5) {
                    k = k + 1;
                    if (j - k < 1) {
                        break;
                    }
                    temp = temp + dp[i - 1][j - k];

                }
                dp[i][j] = temp;
            }
        }
        //取出dp[n,6n]的所有值,代表n个骰子朝上一面数字之和的所有可能结果的出现次数
        int[] dp2 = Arrays.copyOfRange(dp[n], n, 6 * n + 1);
        double sum = 0;
        //所有可能结果出现次数之和
        for (double num : dp2) {
            sum = sum + num;
        }
        double[] res = new double[dp2.length];
        //求概率
        for (int i = 0; i < res.length; i++) {
            res[i] = dp2[i] / sum;
        }
        return res;
    }
//    [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,
//    0.13889,0.11111,0.08333,0.05556,0.02778]
}
//leetcode submit region end(Prohibit modification and deletion)
