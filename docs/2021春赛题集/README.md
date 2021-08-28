## LCP 28. 采购方案

![题目描述](img/LCP28.png)

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

![题目描述](img/LCP29.jpg)

#### 方法一：模拟查找

参考[题解](https://leetcode-cn.com/problems/SNJvJP/solution/san-ju-hua-rang-li-kou-wei-wo-bao-long18-2nsi/)

```python
def orchestraLayout(num: int, xPos: int, yPos: int):
    # 先确定这个位置在第几圈, circle从0开始计数，即第“一”圈为circle == 0
    circle = min(xPos, yPos, num - 1 - xPos, num - 1 - yPos)
    # 记录第circle圈的边长，边长为正方形边长 - 1，每圈过后边长减2
    l = num - 1 - 2 * circle
    count = num * num - (l + 1) * (l + 1)

    if xPos == circle and yPos < num - 1 - circle:
        # 上边
        count += yPos - circle + 1
    elif yPos == num - 1 - circle and xPos < num - 1 - circle:
        # 右边
        count += l + xPos - circle + 1
    elif xPos == num - 1 - circle and yPos > circle:
        # 下边
        count += 2 * l + num - circle - yPos
    else:
        count += 3 * l + num - circle - xPos

    return 9 if count % 9 == 0 else count % 9
```

## LCP 30. 魔塔游戏

![](img/LCP30.jpg)

方法一：堆排序

[题解](https://leetcode-cn.com/problems/p0NxJO/solution/lcp-30-mo-ta-you-xi-biao-zhun-de-xiao-ge-4gkk/)

```python
import heapq

class Solution:
    def magicTower(self, nums):
        if sum(nums) < 0: 
            return -1
        hurts = []
        blood = 0
        counts = 0
        heapq.heapify(hurts)
        for i in nums:
            blood += i
            if i < 0:
                heapq.heappush(hurts, i)   
            if blood < 0:
                counts += 1
                blood -= heapq.heappop(hurts)
        return counts
```

## LCP 31. 变换的迷宫

某解密游戏中，有一个 N\*M 的迷宫，迷宫地形会随时间变化而改变，迷宫出口一直位于 `(n-1,m-1)` 位置。迷宫变化规律记录于 `maze` 中，`maze[i]` 表示 `i` 时刻迷宫的地形状态，`"."` 表示可通行空地，`"#"` 表示陷阱。

地形图初始状态记作 `maze[0]`，此时小力位于起点 `(0,0)`。此后每一时刻可选择往上、下、左、右其一方向走一步，或者停留在原地。

小力背包有以下两个魔法卷轴（卷轴使用一次后消失）：
+ 临时消除术：将指定位置在下一个时刻变为空地；
+ 永久消除术：将指定位置永久变为空地。

请判断在迷宫变化结束前（含最后时刻），小力能否在不经过任意陷阱的情况下到达迷宫出口呢？

**注意： 输入数据保证起点和终点在所有时刻均为空地。**

**示例 1：**
>输入：`maze = [[".#.","#.."],["...",".#."],[".##",".#."],["..#",".#."]]`
>
>输出：`true`
>
>解释：
![maze.gif](https://pic.leetcode-cn.com/1615892239-SCIjyf-maze.gif)


**示例 2：**
>输入：`maze = [[".#.","..."],["...","..."]]`
>
>输出：`false`
>
>解释：由于时间不够，小力无法到达终点逃出迷宫。

**示例 3：**
>输入：`maze = [["...","...","..."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."],[".##","###","##."]]`
>
>输出：`false`
>
>解释：由于道路不通，小力无法到达终点逃出迷宫。

**提示：**
- `1 <= maze.length <= 100`
- `1 <= maze[i].length, maze[i][j].length <= 50`
- `maze[i][j]` 仅包含 `"."`、`"#"`

#### 方法一：双向bfs

[题解](https://leetcode-cn.com/problems/Db3wC1/solution/python3-shuang-xiang-bfsmei-hao-de-shuan-e2ea/)

```python
class Solution:
    def escapeMaze(self, maze: List[List[str]]) -> bool:
        time = len(maze)
        n, m = len(maze[0]), len(maze[0][0])
        if n + m - 2 > time:
            return False
        best = [[[[float('inf'), -1] for i in range(2)] for k in range(m)] for j in range(n)]
        record = [[[[float('inf')] * 2 for k in range(m)]
                   for j in range(n)] for i in range(time)]
        best[0][0][0][0] = 0
        best[n - 1][m - 1][0][1] = time - 1
        record[0][0][0][0] = int(maze[0][0][0] == '#')
        record[time - 1][n - 1][m - 1][1] = int(maze[time - 1][n - 1][m - 1] == '#')
        road = [(0, 0), (0, 1), (1, 0), (0, -1), (-1, 0)]
        z1 = [(0, 0, 0)]
        z2 = [(time - 1, n - 1, m - 1)]
        i, j = 0, 0

        while i < len(z1) or j < len(z2):
            if i < len(z1):
                t, x, y = z1[i]
                if t < time:
                    for a, b in road:
                        o, p = x + a, y + b
                        if -1 < o < n and -1 < p < m and n + m - o - p <= time - t:
                            if not record[t][x][y][0] and max(best[o][p][0][1], best[o][p][1][1]) > t:
                                return True
                            if record[t][x][y][0] and best[o][p][0][1] > t:
                                return True
                            if maze[t + 1][o][p] == '#':
                                if not record[t][x][y][0] and record[t + 1][o][p][0] > 1:
                                    record[t + 1][o][p][0] = 1
                                    z1.append((t + 1, o, p))
                                    best[o][p][0][0] = min(best[o][p][0][0], t + 1)
                            else:
                                if record[t + 1][o][p][0] > record[t][x][y][0]:
                                    now = record[t][x][y][0]
                                    record[t + 1][o][p][0] = now
                                    z1.append((t + 1, o, p))
                                    best[o][p][now][0] = min(best[o][p][now][0], t + 1)
            i += 1
            if j < len(z2):
                t, x, y = z2[j]
                if t:
                    for a, b in road:
                        o, p = x + a, y + b
                        if -1 < o < n and -1 < p < m and o + p <= t - 1:
                            if not record[t][x][y][1] and min(best[o][p][0][0], best[o][p][1][0]) < t:
                                return True
                            if record[t][x][y][1] and best[o][p][0][0] < t:
                                return True
                            if maze[t - 1][o][p] == '#':
                                if not record[t][x][y][1] and record[t - 1][o][p][1] > 1:
                                    record[t - 1][o][p][1] = 1
                                    z2.append((t - 1, o, p))
                                    best[o][p][0][1] = max(best[o][p][0][1], t - 1)
                            else:
                                if record[t - 1][o][p][1] > record[t][x][y][1]:
                                    now = record[t][x][y][1]
                                    record[t - 1][o][p][1] = now
                                    z2.append((t - 1, o, p))
                                    best[o][p][now][1] = max(best[o][p][now][1], t - 1)
            j += 1
        return False
```
## LCP 33. 蓄水

给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 `i` 个水缸配备的水桶容量记作 `bucket[i]`。小扣有以下两种操作：
-  升级水桶：选择任意一个水桶，使其容量增加为 `bucket[i]+1`
-  蓄水：将全部水桶接满水，倒入各自对应的水缸

每个水缸对应最低蓄水量记作 `vat[i]`，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。

注意：实际蓄水量 **达到或超过** 最低蓄水量，即完成蓄水要求。

**示例 1：**
>输入：`bucket = [1,3], vat = [6,8]`
>
>输出：`4`
>
>解释：
>第 1 次操作升级 bucket[0]；
>第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
![vat1.gif](https://pic.leetcode-cn.com/1616122992-RkDxoL-vat1.gif)

**示例 2：**
>输入：`bucket = [9,0,1], vat = [0,2,2]`
>
>输出：`3`
>
>解释：
>第 1 次操作均选择升级 bucket[1]
>第 2~3 次操作选择蓄水，即可完成蓄水要求。

**提示：**
- `1 <= bucket.length == vat.length <= 100`
- `0 <= bucket[i], vat[i] <= 10^4`

[题解](https://leetcode-cn.com/problems/o8SXZn/solution/can-kao-da-lao-de-ti-jie-bao-li-jie-fa-b-1xcs/)

```java
class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        for(int v:vat)
            if(max < v) max = v;
        if(max == 0) return 0;
        int n = bucket.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= 10000; i++) {//遍历倒水次数
            int per = 0;
            int cur = i;//倒水i次，所以操作次数+i
            for(int j = 0; j < n; j++) {//遍历每个水缸
                per = (vat[j] + i - 1) / i;// 水槽容量/倒水次数=每次倒水量
//+（i - 1）目的是为了向上取整(除完后如果有余数，加上i-1之后就一定会多商1，从而达到向上取整的功能)
//使用vat[j]%i==0 ? vat[j]/i : vat[j]/i+1 代替也行，但是更慢
                cur += Math.max(0, per - bucket[j]);// 每次倒水量-初始水量=需要升级次数
            }
            ans = Math.min(ans, cur);//所有倒水次数中，取最小的操作次数
        }
        return ans;
    }
}
```

## LCP 32. 批量处理任务

某实验室计算机待处理任务以 `[start,end,period]` 格式记于二维数组 `tasks`，表示完成该任务的时间范围为起始时间 `start` 至结束时间 `end` 之间，需要计算机投入 `period` 的时长，注意：
1. `period` 可为不连续时间
2. 首尾时间均包含在内

处于开机状态的计算机可同时处理任意多个任务，请返回电脑最少开机多久，可处理完所有任务。

**示例 1：**
>输入：`tasks = [[1,3,2],[2,5,3],[5,6,2]]`
>
>输出：`4`
>
>解释：
>tasks[0] 选择时间点 2、3；
>tasks[1] 选择时间点 2、3、5；
>tasks[2] 选择时间点 5、6；
>因此计算机仅需在时间点 2、3、5、6 四个时刻保持开机即可完成任务。

**示例 2：**
>输入：`tasks = [[2,3,1],[5,5,1],[5,6,2]]`
>
>输出：`3`
>
>解释：
>tasks[0] 选择时间点 2 或 3；
>tasks[1] 选择时间点 5；
>tasks[2] 选择时间点 5、6；
>因此计算机仅需在时间点 2、5、6 或 3、5、6 三个时刻保持开机即可完成任务。

**提示：**
- `2 <= tasks.length <= 10^5`
- `tasks[i].length == 3`
- `0 <= tasks[i][0] <= tasks[i][1] <= 10^9`
- `1 <= tasks[i][2] <= tasks[i][1]-tasks[i][0] + 1`

[题解](https://leetcode-cn.com/problems/t3fKg1/solution/you-xian-dui-lie-tan-xin-rust-by-lucifer-4spv/)

```python
from heapq import heapify, heappush, heappop

class Solution:
    def processTasks(self, tasks: List[List[int]]) -> int:
        n = len(tasks)
        ts = set()
        for s, e, _ in tasks:
            ts.add(s)
            ts.add(e + 1)

        vt = sorted(list(ts))
        mp = dict()
        for i, t in enumerate(vt):
            mp[t] = i

        m = len(vt)
        starts = [[] for _ in range(m)]
        for i, task in enumerate(tasks):
            starts[mp[task[0]]].append(i)
        
        ans = 0
        extra = 0 # 关键变量，用于修正优先队列内的数值
        pq = []
        heapify(pq)

        for i in range(m - 1):
            while pq and tasks[pq[0][1]][1] < vt[i]:
                heappop(pq)
            
            for u in starts[i]:
                heappush(pq, (extra + tasks[u][1] - vt[i] + 1 - tasks[u][2], u))

            current_seg = vt[i + 1] - vt[i]

            if pq:
                # 减去extra得到实际的空余槽位数目。
                min_slots = pq[0][0] - extra
                slots_to_del = current_seg

                # 如果空余槽位最少的那个任务的空余槽位小于当前区间的长度，则当前区间需要安排任务。
                if min_slots < current_seg:
                    delta = current_seg - min_slots
                    ans += delta
                    slots_to_del -= delta

                # 需要减少当前队列内的任务的空余槽位，这里显然不能逐个修改，所以变为增加之后入队的任务的数值。
                extra += slots_to_del

        return ans
```

## LCP 34. 二叉树染色

小扣有一个根结点为 `root` 的二叉树模型，初始所有结点均为白色，可以用蓝色染料给模型结点染色，模型的每个结点有一个 `val` 价值。小扣出于美观考虑，希望最后二叉树上每个蓝色相连部分的结点个数不能超过 `k` 个，求所有染成蓝色的结点价值总和最大是多少？


**示例 1：**
> 输入：`root = [5,2,3,4], k = 2`
>
> 输出：`12`
>
> 解释：`结点 5、3、4 染成蓝色，获得最大的价值 5+3+4=12`
![image.png](https://pic.leetcode-cn.com/1616126267-BqaCRj-image.png)


**示例 2：**
> 输入：`root = [4,1,3,9,null,null,2], k = 2`
>
> 输出：`16`
>
> 解释：结点 4、3、9 染成蓝色，获得最大的价值 4+3+9=16
![image.png](https://pic.leetcode-cn.com/1616126301-gJbhba-image.png)



**提示：**
+ `1 <= k <= 10`
+ `1 <= val <= 10000`
+ `1 <= 结点数量 <= 10000`


## LCP 35. 电动车游城市

小明的电动车电量充满时可行驶距离为 `cnt`，每行驶 1 单位距离消耗 1 单位电量，且花费 1 单位时间。小明想选择电动车作为代步工具。地图上共有 N 个景点，景点编号为 0 ~ N-1。他将地图信息以 `[城市 A 编号,城市 B 编号,两城市间距离]` 格式整理在在二维数组 `paths`，表示城市 A、B 间存在双向通路。初始状态，电动车电量为 0。每个城市都设有充电桩，`charge[i]` 表示第 i 个城市每充 1 单位电量需要花费的单位时间。请返回小明最少需要花费多少单位时间从起点城市 `start` 抵达终点城市 `end`。


**示例 1：**
>输入：`paths = [[1,3,3],[3,2,1],[2,1,3],[0,1,4],[3,0,5]], cnt = 6, start = 1, end = 0, charge = [2,10,4,1]`
>
>输出：`43`
>
>解释：最佳路线为：1->3->0。
>在城市 1 仅充 3 单位电至城市 3，然后在城市 3 充 5 单位电，行驶至城市 5。
>充电用时共 3\*10 + 5\*1= 35
>行驶用时 3 + 5 = 8，此时总用时最短 43。
![image.png](https://pic.leetcode-cn.com/1616125304-mzVxIV-image.png)

**示例 2：**
>输入：`paths = [[0,4,2],[4,3,5],[3,0,5],[0,1,5],[3,2,4],[1,2,8]], cnt = 8, start = 0, end = 2, charge = [4,1,1,3,2]`
>
>输出：`38`
>
>解释：最佳路线为：0->4->3->2。
>城市 0 充电 2 单位，行驶至城市 4 充电 8 单位，行驶至城市 3 充电 1 单位，最终行驶至城市 2。
>充电用时 4\*2+2\*8+3\*1 = 27
>行驶用时 2+5+4 = 11，总用时最短 38。

**提示：**
- `1 <= paths.length <= 200`
- `paths[i].length == 3`
- `2 <= charge.length == n <= 100`
- `0 <= path[i][0],path[i][1],start,end < n`
- `1 <= cnt <= 100`
- `1 <= path[i][2] <= cnt`
- `1 <= charge[i] <= 100`
- 题目保证所有城市相互可以到达

## LCP 36. 最多牌组数

麻将的游戏规则中，共有两种方式凑成「一组牌」：
- 顺子：三张牌面数字连续的麻将，例如 [4,5,6]
- 刻子：三张牌面数字相同的麻将，例如 [10,10,10]

给定若干数字作为麻将牌的数值（记作一维数组 `tiles`），请返回所给 `tiles` 最多可组成的牌组数。

注意：凑成牌组时，每张牌仅能使用一次。

**示例 1：**
>输入：`tiles = [2,2,2,3,4]`
>
>输出：`1`
>
>解释：最多可以组合出 [2,2,2] 或者 [2,3,4] 其中一组牌。

**示例 2：**
>输入：`tiles = [2,2,2,3,4,1,3]`
>
>输出：`2`
>
>解释：最多可以组合出 [1,2,3] 与 [2,3,4] 两组牌。

**提示：**
- `1 <= tiles.length <= 10^5`
- `1 <= tiles[i] <= 10^9`

## LCP 37. 最小矩形面积

二维平面上有 $N$ 条直线，形式为 `y = kx + b`，其中 `k`、`b`为整数 且 `k > 0`。所有直线以 `[k,b]` 的形式存于二维数组 `lines` 中，不存在重合的两条直线。两两直线之间可能存在一个交点，最多会有 $C_N^2$ 个交点。我们用一个平行于坐标轴的矩形覆盖所有的交点，请问这个矩形最小面积是多少。若直线之间无交点、仅有一个交点或所有交点均在同一条平行坐标轴的直线上，则返回0。

注意：返回结果是浮点数，与标准答案 **绝对误差或相对误差** 在 10^-4 以内的结果都被视为正确结果


**示例 1：**
> 输入：`lines = [[2,3],[3,0],[4,1]]`
>
> 输出：`48.00000`
>
> 解释：三条直线的三个交点为 (3, 9) (1, 5) 和 (-1, -3)。最小覆盖矩形左下角为 (-1, -3) 右上角为 (3,9)，面积为 48


**示例 2：**
> 输入：`lines = [[1,1],[2,3]]`
>
> 输出：`0.00000`
>
> 解释：仅有一个交点 (-2，-1）


**限制：**
+ `1 <= lines.length <= 10^5 且 lines[i].length == 2`
+ `1 <= lines[0] <= 10000`
+ `-10000 <= lines[1] <= 10000`
+ `与标准答案绝对误差或相对误差在 10^-4 以内的结果都被视为正确结果`

## LCP 38. 守卫城堡

城堡守卫游戏的胜利条件为使恶魔无法从出生点到达城堡。游戏地图可视作 `2*N` 的方格图，记作字符串数组 `grid`，其中：
- `"."` 表示恶魔可随意通行的平地；
- `"#"` 表示恶魔不可通过的障碍物，玩家可通过在 **平地** 上设置障碍物，即将  `"."` 变为 `"#"` 以阻挡恶魔前进；
- `"S"` 表示恶魔出生点，将有大量的恶魔该点生成，恶魔可向上/向下/向左/向右移动，且无法移动至地图外；
- `"P"` 表示瞬移点，移动到 `"P"` 点的恶魔可被传送至任意一个 `"P"` 点，也可选择不传送；
- `"C"` 表示城堡。

然而在游戏中用于建造障碍物的金钱是有限的，请返回玩家最少需要放置几个障碍物才能获得胜利。若无论怎样放置障碍物均无法获胜，请返回 `-1`。

**注意：**
- 地图上可能有一个或多个出生点
- 地图上有且只有一个城堡

**示例 1**
>输入：`grid = ["S.C.P#P.", ".....#.S"]`
>
>输出：`3`
>
>解释：至少需要放置三个障碍物
![image.png](https://pic.leetcode-cn.com/1614828255-uuNdNJ-image.png)


**示例 2：**
>输入：`grid = ["SP#P..P#PC#.S", "..#P..P####.#"]`
>
>输出：`-1`
>
>解释：无论怎样修筑障碍物，均无法阻挡最左侧出生的恶魔到达城堡位置
![image.png](https://pic.leetcode-cn.com/1614828208-oFlpVs-image.png)

**示例 3：**
>输入：`grid = ["SP#.C.#PS", "P.#...#.P"]`
>
>输出：`0`
>
>解释：无需放置障碍物即可获得胜利
![image.png](https://pic.leetcode-cn.com/1614828242-oveClu-image.png)

**示例 4：**
>输入：`grid = ["CP.#.P.", "...S..S"]`
>
>输出：`4`
>
>解释：至少需要放置 4 个障碍物，示意图为放置方法之一
![image.png](https://pic.leetcode-cn.com/1614828218-sIAYkb-image.png)


**提示：**
- `grid.length == 2`
- `2 <= grid[0].length == grid[1].length <= 10^4`
- `grid[i][j]` 仅包含字符 `"."`、`"#"`、`"C"`、`"P"`、`"S"`
