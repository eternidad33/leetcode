def countPrefixes(words, s):
    count = 0
    for word in words:
        l = len(word)
        if word == s[:l]:
            count += 1
    return count


print(countPrefixes(["apple", "app", "appl", "appl"], "app"))
