class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        """
        没做出来，感觉用动态规划
        滑动窗口
        :param blocks:
        :param k:
        :return:
        """
        n = len(blocks)
        ans = k
        for i in range(n - k + 1):
            cur = blocks[i:i + k].count('W')
            if cur < ans:
                ans = cur
        return ans
