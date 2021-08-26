## LCP 28. 采购方案

![题目描述](img/LCP28.采购方案.png)

#### 方法一：暴力（超时）

直接两重循环，遍历数组

```python
def purchasePlans(nums, target):
    """采购方案"""
    count = 0
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] <= target:
                count += 1
    return count
```

#### 方法二：排序+双指针

- 先将数组排序，然后采用双指针
- `start`和`end`分别从左边和右边遍历，
- 找到第一个对应的`end`使得`nums[start]+nums[end]<=target`，代表和`nums[start]`一起采购的方案有`end - start`个

```python
def purchasePlans(nums, target):
    nums.sort()
    count = 0
    # print(nums)
    for start in range(len(nums)):
        for end in range(len(nums) - 1, start, -1):
            if nums[start] + nums[end] <= target:
                count += (end - start)
                count %= 1000000007
                # print(str(end) + ' - ' + str(start))
                break
    return count
```

上面的代码超时，本质上还是两层循环，不超时的写法如下

```python
def purchasePlans(nums, target):
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
```

> sorted(nums)方法会对nums进行排序，然后生成新的序列但不会改变nums原来的顺序，nums.sort()会直接对nums进行排序

## LCP 29. 乐团站位

## LCP 30. 魔塔游戏

## LCP 31. 变换的迷宫

## LCP 33. 蓄水

## LCP 32. 批量处理任务

## LCP 34. 二叉树染色

## LCP 35. 电动车游城市

## LCP 36. 最多牌组数

## LCP 37. 最小矩形面积

## LCP 38. 守卫城堡
