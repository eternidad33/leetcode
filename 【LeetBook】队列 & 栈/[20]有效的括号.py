# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
# 
#  有效字符串需满足： 
# 
#  
#  左括号必须用相同类型的右括号闭合。 
#  左括号必须以正确的顺序闭合。 
#  
# 
#  注意空字符串可被认为是有效字符串。 
# 
#  示例 1: 
# 
#  输入: "()"
# 输出: true
#  
# 
#  示例 2: 
# 
#  输入: "()[]{}"
# 输出: true
#  
# 
#  示例 3: 
# 
#  输入: "(]"
# 输出: false
#  
# 
#  示例 4: 
# 
#  输入: "([)]"
# 输出: false
#  
# 
#  示例 5: 
# 
#  输入: "{[]}"
# 输出: true 
#  Related Topics 栈 字符串 
#  👍 1920 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 == 1:
            return False

        ps = {")": "(", "]": "[", "}": "{"}

        # 键值对判断键是否在字典里
        # ps = {")": "(", "]": "[", "}": "{"}
        # "(" in ps
        # Out[22]: False
        # ")" in ps
        # Out[23]: True

        # 左半括号进栈,匹配右半括号
        stack = []
        for ch in s:
            if ch in ps:
                # 栈空 或者 不匹配
                if not stack or stack[-1]!=ps[ch]:
                    return False
                # 匹配出栈
                stack.pop()
            else:
                stack.append(ch)
        # 若匹配成功最后栈应为空
        return not stack


    # leetcode submit region end(Prohibit modification and deletion)
