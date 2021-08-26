def purchasePlans(nums, target):
    """采购方案"""
    # 方法一：暴力（超时）
    # count = 0
    # for i in range(len(nums)):
    #     for j in range(i + 1, len(nums)):
    #         if nums[i] + nums[j] <= target:
    #             count += 1
    # return count

    # 方法二：排序+双指针
    nums.sort()
    ans = 0
    i = 0
    j = len(nums) - 1
    while i < j:
        if nums[i] + nums[j] > target:
            j -= 1
        else:
            ans += (j - i)
            i += 1
    if ans <= 1000000007:
        return ans
    else:
        return ans % 1000000007


# purchasePlans([2, 5, 3, 5], 6)
a = purchasePlans([2, 2, 1, 9], 10)
print(a)
