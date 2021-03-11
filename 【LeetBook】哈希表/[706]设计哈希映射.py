# 不使用任何内建的哈希表库设计一个哈希映射 
# 
#  具体地说，你的设计应该包含以下的功能 
# 
#  
#  put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。 
#  get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。 
#  remove(key)：如果映射中存在这个键，删除这个数值对。 
#  
# 
#  
# 示例： 
# 
#  MyHashMap hashMap = new MyHashMap();
# hashMap.put(1, 1);          
# hashMap.put(2, 2);         
# hashMap.get(1);            // 返回 1
# hashMap.get(3);            // 返回 -1 (未找到)
# hashMap.put(2, 1);         // 更新已有的值
# hashMap.get(2);            // 返回 1 
# hashMap.remove(2);         // 删除键为2的数据
# hashMap.get(2);            // 返回 -1 (未找到) 
#  
# 
#  
# 注意： 
# 
#  
#  所有的值都在 [0, 1000000]的范围内。 
#  操作的总数目在[1, 10000]范围内。 
#  不要使用内建的哈希库。 
#  
#  Related Topics 设计 哈希表 
#  👍 86 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class Bucket:
    """
    桶，通过列表实现哈希映射
    """

    def __init__(self):
        self.bucket = []

    def get(self, key):
        """获取key对应的value"""
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        """更新键值对"""
        found = False
        for i, kv in enumerate(self.bucket):
            # 如果已经存在，更新
            if key == kv[0]:
                self.bucket[i] = (key, value)
                found = True
                break

        # 如果不存在，添加
        if not found:
            self.bucket.append((key, value))

    def remove(self, key):
        """删除键值对"""
        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 2069
        self.hash_table = [Bucket() for _ in range(self.key_space)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        # 计算哈希值
        hash_key = key % self.key_space
        self.hash_table[hash_key].update(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        # 计算哈希值
        hash_key = key % self.key_space
        return self.hash_table[hash_key].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        # 计算哈希值
        hash_key = key % self.key_space
        self.hash_table[hash_key].remove(key)
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
# leetcode submit region end(Prohibit modification and deletion)
