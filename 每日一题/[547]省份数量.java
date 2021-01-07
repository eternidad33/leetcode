//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。
// 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，
// 那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，
// 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
// 而isConnected[i][j] = 0 表示二者不直接相连。
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 442 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 存储结果
        int result = 0;

        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                result++;
            }
        }

        return result;
    }

    /**
     * 深度优先搜索，结点i的所有连接节点
     *
     * @param graph   图
     * @param visited 标记访问的节点
     * @param i       节点i
     * @return void
     */
    public void dfs(int[][] graph, boolean[] visited, int i) {
        for (int j = 0; j < graph.length; j++) {
            // 如果i和j连通且未被访问，标记并遍历
            if (graph[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(graph, visited, j);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
