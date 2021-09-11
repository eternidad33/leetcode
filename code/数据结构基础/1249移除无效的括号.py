def minRemoveToMakeValid(s: str) -> str:
    # 用集合存储要删除的索引，用一个列表存储括号匹配
    indexes_to_remove = set()
    stack = []
    for i, c in enumerate(s):
        if c not in "()":
            continue
        if c == "(":
            stack.append(i)
        elif not stack:
            # ) 出现的时候栈中没有 ( ，集合中加入索引
            indexes_to_remove.add(i)
        else:
            # ) 匹配，( 出栈
            stack.pop()
    # 索引取与未匹配的)的索引的并集
    indexes_to_remove = indexes_to_remove.union(set(stack))
    string_builder = []
    for i, c in enumerate(s):
        if i not in indexes_to_remove:
            string_builder.append(c)
    return "".join(string_builder)


a = minRemoveToMakeValid("lee(t(c)o)de)")
print(a)
