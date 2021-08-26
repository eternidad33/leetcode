def orchestraLayout(num: int, xPos: int, yPos: int):
    # 先确定这个位置在第几圈, circle从0开始计数，即第“一”圈为circle == 0
    circle = min(xPos, yPos, num - 1 - xPos, num - 1 - yPos)
    # 记录第circle圈的边长，边长为正方形边长 - 1，每圈过后边长减2
    l = num - 1 - 2 * circle
    count = num * num - (l + 1) * (l + 1)

    if xPos == circle and yPos < num - 1 - circle:
        # 上边
        count += yPos - circle + 1
    elif yPos == num - 1 - circle and xPos < num - 1 - circle:
        # 右边
        count += l + xPos - circle + 1
    elif xPos == num - 1 - circle and yPos > circle:
        # 下边
        count += 2 * l + num - circle - yPos
    else:
        count += 3 * l + num - circle - xPos

    return 9 if count % 9 == 0 else count % 9
