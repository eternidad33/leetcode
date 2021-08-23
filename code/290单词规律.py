def wordPattern(pattern, s: str):
    word2ch = {}
    ch2word = {}
    words = s.split()
    # 单词组长度和匹配串长度不同，返回False
    if len(words) != len(pattern):
        return False

    for ch, word in zip(pattern, words):
        if (word in word2ch and word2ch[word] != ch) or (ch in ch2word and ch2word[ch] != word):
            return False
        word2ch[word] = ch
        ch2word[ch] = word

    return True
