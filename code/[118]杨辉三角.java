//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 动态规划 
// 👍 527 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 数学
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            // 填充每一行的列表
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 第一个或最后一个数为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 其他数为上边的两个数相加
                    row.add(ret.get(i - 1).get(j) + ret.get(i - 1).get(j - 1));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
