import heapq


def magicTower(nums):
    """
    先遍历计算最后和是否为负数，负数直接返回
    堆排序：将怪物房间存放进小根堆，数越小扣血越多
    :param nums: 房间存放的是怪物（负数），补血（正数）
    :return: 需移动次数
    """
    if sum(nums) < 0:
        return -1
    count = 0  # 移动次数
    hurts = list()  # 扣血的房间
    blood = 0  # 存储当前血量
    heapq.heapify(hurts)
    for num in nums:
        blood += num
        if num < 0:
            """房间值为负数，放入堆中"""
            heapq.heappush(hurts, num)
        if blood < 0:
            """当前血量小于0，将堆中扣血最多的数也就是最小负数移动到后边，同时count+1"""
            count += 1
            blood -= heapq.heappop(hurts)

    return count


l = [100, 100, 100, -250, -60, -140, -50, -50, 100, 150]
c = magicTower(l)
print(c)
