def convertTime(current: str, correct: str):
    cur_hour, cur_minute = map(int, current.split(':'))  # 当前时间
    cor_hour, cor_minute = map(int, correct.split(':'))  # 目标时间
    res = 0
    minutes = ((cor_hour - cur_hour) * 60 + cor_minute - cur_minute + 24 * 60) % (24 * 60)
    res += minutes // 60
    minutes %= 60
    res += minutes // 15
    minutes %= 15
    res += minutes // 5
    minutes %= 5
    return res + minutes


print(convertTime('23:59', '00:00'))  # 1
