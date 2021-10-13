from typing import List


def findSmallestSetOfVertices(n: int, edges: List[List[int]]) -> List[int]:
    """可以到达所有点的最少点数目"""
    fromNode = set()
    toNode = set()
    for x, y in edges:
        fromNode.add(x)
        toNode.add(y)
    # 去掉所有中间节点
    return list(fromNode - toNode)
