from collections import deque


def findTheWinner(n, k):
    # if n == 1:
    #     return 1
    # val = 0
    # for i in range(2, n + 1):
    #     val = (val + k) % i
    # return val + 1
    q = deque(range(1, n + 1))
    i = 1
    while len(q) > 1:
        if i % k:
            """i不是k的倍数，将队首元素移到队尾"""
            q.append(q.popleft())
        else:
            """i是k的倍数出队"""
            q.popleft()
        i += 1
    return q.pop()
