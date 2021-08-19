# 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
# 
#  实现 MyHashMap 类： 
# 
#  
#  MyHashMap() 用空映射初始化对象 
#  void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
# 则更新其对应的值 value 。 
#  int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
#  void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
#  
# 
#  
# 
#  示例： 
# 
#  
# 输入：
# ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
# [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
# 输出：
# [null, null, null, 1, -1, null, 1, null, -1]
# 
# 解释：
# MyHashMap myHashMap = new MyHashMap();
# myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
# myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
# myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
# myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
# myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
# myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
# myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
# myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= key, value <= 10⁶ 
#  最多调用 10⁴ 次 put、get 和 remove 方法 
#  
# 
#  
# 
#  进阶：你能否不使用内置的 HashMap 库解决此问题？ 
#  Related Topics 设计 数组 哈希表 链表 哈希函数 👍 214 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.N = 1009
        self.data = [[] for i in range(self.N)]

    def getHash(self, key):
        """获取key的哈希值"""
        return key % self.N

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashKey = self.getHash(key)
        # 遍历地址为hashKey的bucket中的entry
        for entry in self.data[hashKey]:
            if entry[0] == key:
                entry[1] = value
                return
        # bucket中不包含该元素
        self.data[hashKey].append([key, value])

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashKey = self.getHash(key)
        for entry in self.data[hashKey]:
            if entry[0] == key:
                return entry[1]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashKey = self.getHash(key)
        for index, entry in enumerate(self.data[hashKey]):
            if entry[0] == key:
                self.data[hashKey].pop(index)
                return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
# leetcode submit region end(Prohibit modification and deletion)
