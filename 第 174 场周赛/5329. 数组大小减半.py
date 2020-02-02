class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        s1 = set(arr)
        n = len(arr)/2
        clist = []
        for s in s1:
            clist.append(arr.count(s))
        clist.sort(reverse=True)
        s, i = 0, 0
        for c in clist:
            s += c
            i += 1
            if s >= n:
                break
        return i
