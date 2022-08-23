R = ['999', '888', '777', '666', '555', '444', '333', '222', '111', '000']


def largestGoodInteger(num: str) -> str:
    return next(filter(lambda r: r in num, R), '')
