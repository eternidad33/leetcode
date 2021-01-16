//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 202 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dight_sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

//    //方法1：dfs（1ms）
//    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
//        //边界情况，已经遍历过，不合题意
//        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true
//                || dight_sum(i) + dight_sum(j) > k) {
//            return 0;
//        }
//        visited[i][j] = true;
////        return 1 + dfs(i - 1, j, m, n, k, visited) + dfs(i + 1, j, m, n, k, visited) +
////                dfs(i, j - 1, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
//        //只向右下搜索
//        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
//    }

    public int movingCount(int m, int n, int k) {
//        //dfs
//        boolean[][] visited = new boolean[m][n];
//        int result = dfs(0, 0, m, n, k, visited);
//        return result;

//        //方法2：bfs(5ms)
//        if (k == 0) {
//            return 1;
//        }
//        Queue<int[]> queue = new LinkedList<>();
//        int[] dx = {0, 1};
//        int[] dy = {1, 0};
//        boolean[][] visited = new boolean[m][n];
//        queue.offer(new int[]{0, 0});
//        visited[0][0] = true;
//        int ans = 1;
//        while (!queue.isEmpty()) {
//            int[] cell = queue.poll();
//            //提取横纵坐标
//            int x = cell[0], y = cell[1];
//            for (int i = 0; i < 2; i++) {
//                //只向右下遍历，dx[i]和dx[j]正好对应右和下
//                int tx = dx[i] + x;
//                int ty = dy[i] + y;
//                if (tx >= m || ty >= n || visited[tx][ty] || dight_sum(tx) + dight_sum(ty) > k) {
//                    //跳过此次循环
//                    continue;
//                }
//                queue.offer(new int[]{tx, ty});
//                visited[tx][ty] = true;
//                ans++;
//            }
//        }
//        return ans;

        //方法3：递推(4ms)
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 位数和大于k
                if (dight_sum(i) + dight_sum(j) > k) {
                    continue;
                }

                //边界情况，第0行和第0列
                if (i - 1 >= 0) {
                    //上方
                    visited[i][j] |= visited[i - 1][j];
                }
                if (j - 1 >= 0) {
                    //左侧
                    visited[i][j] |= visited[i][j - 1];
                }

                ans += visited[i][j] ? 1 : 0;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
