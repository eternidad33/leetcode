def strongPasswordCheckerII(password: str) -> bool:
    s = set(password)
    if len(password) >= 8 and s & set([chr(i) for i in range(97, 123)]) and s & set([chr(i) for i in range(65, 91)]) and \
            s & set([str(i) for i in range(0, 10)]) and s & set(list("!@#$%^&*()-+")):
        for i in range(len(password) - 1):
            if password[i + 1] == password[i]:
                return False
        return True
    return False


s1 = "1234564646ajhsdkhk#asdhgvbahj"
print(strongPasswordCheckerII(s1))
