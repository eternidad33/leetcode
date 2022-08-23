def maxSubArray(nums):
    '''
    :type nums: List[int]
    :param nums: 数组
    :return: 子数组最大和
    '''
    for i in range(1, len(nums)):
        nums[i] = max(nums[i], nums[i] + nums[i - 1])
    return max(nums)


nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(maxSubArray(nums))
