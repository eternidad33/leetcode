def percentageLetter(s: str, letter: str) -> int:
    n = len(s)
    c = s.count(letter)
    return int(c / n * 100)
