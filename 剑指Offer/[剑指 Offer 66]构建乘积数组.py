# 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
# i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
# 
#  
# 
#  示例: 
# 
#  
# 输入: [1,2,3,4,5]
# 输出: [120,60,40,30,24] 
# 
#  
# 
#  提示： 
# 
#  
#  所有元素乘积之和不会溢出 32 位整数 
#  a.length <= 100000 
#  
#  👍 99 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def constructArr(self, a: List[int]) -> List[int]:
        # 定义列表b
        b = [1 for _ in range(len(a))]
        # b[i]先存储为a中前i-1个数的乘积
        for i in range(1, len(a)):
            b[i] = b[i - 1] * a[i - 1]

        temp = 1
        for j in range(len(a) - 2, -1, -1):
            # 记录后半段数的乘积
            temp *= a[j + 1]
            b[j] *= temp

        return b

# leetcode submit region end(Prohibit modification and deletion)
