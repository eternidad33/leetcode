#!/usr/bin/python3
# -*- coding:utf-8 -*-
"""
@author: Vigilr
@file: 5483. 整理字符串.py
@date: 2020-08-09
@Editor: PyCharm
@desc: 
"""


def makeGood(s: str) -> str:
    l = list(s)
    for i in range(len(l) - 1):
        if l[i].islower():
            if l[i + 1].isupper() and l[i] == l[i + 1].lower():
                # 删除这两个字符
                l[i + 1] = " "
                l[i] = " "
        if l[i].isupper():
            if l[i + 1].islower() and l[i] == l[i + 1].upper():
                l[i + 1] = " "
                l[i] = " "
    ls = "".join(l).replace(" ", "")
    flag = False
    for i in range(len(ls) - 1):
        if ls[i].islower() and ls[i + 1].isupper() and ls[i] == ls[i + 1].lower():
            flag = True
        if ls[i].isupper() and ls[i + 1].islower() and ls[i] == ls[i + 1].upper():
            flag = True
    if flag:
        return makeGood(ls)
    else:
        return ls


s1 = makeGood("leeEetcode")
s2 = makeGood("abBAcC")
print("【测试结果1】" + s1)
print("【测试结果2】" + s2)


class Solution:
    def makeGood(self, s: str) -> str:
        l = list(s)
        for i in range(len(l) - 1):
            if l[i].islower():
                if l[i + 1].isupper() and l[i] == l[i + 1].lower():
                    # 删除这两个字符
                    l[i + 1] = " "
                    l[i] = " "
            if l[i].isupper():
                if l[i + 1].islower() and l[i] == l[i + 1].upper():
                    l[i + 1] = " "
                    l[i] = " "
        ls = "".join(l).replace(" ", "")
        flag = False
        for i in range(len(ls) - 1):
            if ls[i].islower() and ls[i + 1].isupper() and ls[i] == ls[i + 1].lower():
                flag = True
            if ls[i].isupper() and ls[i + 1].islower() and ls[i] == ls[i + 1].upper():
                flag = True
        if flag:
            return self.makeGood(ls)
        else:
            return ls
