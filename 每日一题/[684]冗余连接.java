//在本问题中, 树指的是一个连通且无环的无向图。 
//
// 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属
//于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。 
//
// 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
// 
//
// 示例 1： 
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的无向图为:
//  1
// / \
//2 - 3
// 
//
// 示例 2： 
//
// 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
//解释: 给定的无向图为:
//5 - 1 - 2
//    |   |
//    4 - 3
// 
//
// 注意: 
//
// 
// 输入的二维数组大小在 3 到 1000。 
// 二维数组中的整数在1到N之间，其中N是输入数组的大小。 
// 
//
// 更新(2017-09-26): 
//我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。 
// Related Topics 树 并查集 图 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int count = edges.length;
        int[] parent = new int[count + 1];
        // 数组初始化为-1
        for (int i = 0; i <= count; i++) {
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!union(x, y, parent)) {
                return edge;
            }
        }
        return new int[0];
    }

    /**
     * 查找节点x的根节点
     *
     * @return int
     */
    public int findRoot(int x, int[] parent) {
        int x_root = x;
        // 直到查找到索引值为-1
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }

    /**
     * 是否属于两个不同的集合，不同就合并
     *
     * @return boolean
     */
    public boolean union(int x, int y, int[] parent) {
        int x_root = findRoot(x, parent);
        int y_root = findRoot(y, parent);
        // x和y的根节点属于两个集合，合并
        if (x_root != y_root) {
            parent[y_root] = x_root;
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
