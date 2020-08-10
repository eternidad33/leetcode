# 给出一个区间的集合，请合并所有重叠的区间。 
# 
#  示例 1: 
# 
#  输入: [[1,3],[2,6],[8,10],[15,18]]
# 输出: [[1,6],[8,10],[15,18]]
# 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
#  
# 
#  示例 2: 
# 
#  输入: [[1,4],[4,5]]
# 输出: [[1,5]]
# 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
#  Related Topics 排序 数组 
#  👍 542 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort(key=lambda x: x[0])

        merged = []
        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged
# leetcode submit region end(Prohibit modification and deletion)
