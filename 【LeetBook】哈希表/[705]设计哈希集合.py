# 不使用任何内建的哈希表库设计一个哈希集合 
# 
#  具体地说，你的设计应该包含以下的功能 
# 
#  
#  add(value)：向哈希集合中插入一个值。 
#  contains(value) ：返回哈希集合中是否存在这个值。 
#  remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
#  
# 
#  
# 示例: 
# 
#  MyHashSet hashSet = new MyHashSet();
# hashSet.add(1);         
# hashSet.add(2);         
# hashSet.contains(1);    // 返回 true
# hashSet.contains(3);    // 返回 false (未找到)
# hashSet.add(2);          
# hashSet.contains(2);    // 返回 true
# hashSet.remove(2);          
# hashSet.contains(2);    // 返回  false (已经被删除)
#  
# 
#  
# 注意： 
# 
#  
#  所有的值都在 [0, 1000000]的范围内。 
#  操作的总数目在[1, 10000]范围内。 
#  不要使用内建的哈希集合库。 
#  
#  Related Topics 设计 哈希表 
#  👍 66 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash_set = set()

    def add(self, key: int) -> None:
        self.hash_set.add(key)

    def remove(self, key: int) -> None:
        if self.contains(key):
            self.hash_set.remove(key)
        else:
            return

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        return key in self.hash_set

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
# leetcode submit region end(Prohibit modification and deletion)
