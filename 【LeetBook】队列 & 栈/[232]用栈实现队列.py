# 使用栈实现队列的下列操作： 
# 
#  
#  push(x) -- 将一个元素放入队列的尾部。 
#  pop() -- 从队列首部移除元素。 
#  peek() -- 返回队列首部的元素。 
#  empty() -- 返回队列是否为空。 
#  
# 
#  
# 
#  示例: 
# 
#  MyQueue queue = new MyQueue();
# 
# queue.push(1);
# queue.push(2);  
# queue.peek();  // 返回 1
# queue.pop();   // 返回 1
# queue.empty(); // 返回 false 
# 
#  
# 
#  说明: 
# 
#  
#  你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
#  
#  你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
#  假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。 
#  
#  Related Topics 栈 设计 
#  👍 242 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # 初始化两个栈
        self.stack1 = []
        self.stack2 = []
        self.front = None

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        if not self.stack1:
            self.front = x
        # 新元素直接进栈1
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            self.front = None
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        # 栈2有元素直接返回最后一个元素
        if self.stack2:
            return self.stack2[-1]
        return self.front

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.stack2 and not self.stack1

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
# leetcode submit region end(Prohibit modification and deletion)
