#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个有序数组的中位数
#

# @lc code=start


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        newNum = nums1+nums2
        newNum.sort()
        l = len(newNum)
        if l % 2 == 1:
            return newNum[int(l/2)]
        else:
            return (newNum[int(l/2)-1]+newNum[int(l/2)])/2
# @lc code=end
