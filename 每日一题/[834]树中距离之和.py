# 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
# 
#  第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
# 
#  返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
# 
#  示例 1: 
# 
#  
# 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
# 输出: [8,12,6,10,10,10]
# 解释: 
# 如下为给定的树的示意图：
#   0
#  / \
# 1   2
#    /|\
#   3 4 5
# 
# 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
# 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
#  
# 
#  说明: 1 <= N <= 10000 
#  Related Topics 树 深度优先搜索 
#  👍 210 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def sumOfDistancesInTree(self, N, edges):
        """
        :type N: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        graph = [[] for _ in range(N)]
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        dist_sum = [0 for _ in range(N)]
        node_num = [1 for _ in range(N)]

        def post_order(node, parent):
            for n in graph[node]:
                if n == parent:
                    continue
                post_order(n, node)
                node_num[node] += node_num[n]
                dist_sum[node] += dist_sum[n] + node_num[n]

        def pre_order(node, parent):
            for n in graph[node]:
                if n == parent:
                    continue
                dist_sum[n] = dist_sum[node] - node_num[n] + (N - node_num[n])
                pre_order(n, node)

        post_order(0, -1)
        pre_order(0, -1)
        return dist_sum
# leetcode submit region end(Prohibit modification and deletion)
