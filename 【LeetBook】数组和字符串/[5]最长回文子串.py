# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
# 
#  示例 1： 
# 
#  输入: "babad"
# 输出: "bab"
# 注意: "aba" 也是一个有效答案。
#  
# 
#  示例 2： 
# 
#  输入: "cbbd"
# 输出: "bb"
#  
#  Related Topics 字符串 动态规划 
#  👍 2717 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        if not s:
            return ""
        length = len(s)
        if length == 1 or s == s[::-1]:
            return s
        max_len, start = 1, 0
        for i in range(1, length):
            even = s[i - max_len:i + 1]
            odd = s[i - max_len - 1:i + 1]
            if i - max_len - 1 >= 0 and odd == odd[::-1]:
                start = i - max_len - 1
                max_len += 2
                continue
            if i - max_len >= 0 and even == even[::-1]:
                start = i - max_len
                max_len += 1
                continue
        return s[start:start + max_len]

        # # 动态规划
        # n = len(s)
        # dp = [[False] * n for _ in range(n)]
        # ans = ""
        # # 枚举子串的长度 length+1
        # for length in range(n):
        #     # 枚举子串的起始位置 i，这样可以通过 j=i+length 得到子串的结束位置
        #     for i in range(n):
        #         j = i + length
        #         if j >= len(s):
        #             break
        #         if length == 0:
        #             dp[i][j] = True
        #         elif length == 1:
        #             dp[i][j] = (s[i] == s[j])
        #         else:
        #             dp[i][j] = (dp[i + 1][j - 1] and s[i] == s[j])
        #         if dp[i][j] and length + 1 > len(ans):
        #             ans = s[i:j + 1]
        # return ans

# leetcode submit region end(Prohibit modification and deletion)
