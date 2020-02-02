class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        troup, tIndex, result = [], [], []
        for m in mat:
            temp = sum(m)
            troup.append(temp)
            tIndex.append([mat.index(m), temp])
        troup.sort()
        for t in troup:
            for t1 in tIndex:
                if t == t1[1]:
                    result.append(t1[0])
                    tIndex.remove(t1)
        return result[:k]
