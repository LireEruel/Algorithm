# https://www.acmicpc.net/problem/3052
# 아이디어 : 그냥 나머지 다 구한담에 그거 Set에 넣으면 될 것 같다.


def solution():
    remainSet = set()
    for i in range(10):
        remainSet.add(int(input()) % 42)
    print(len(remainSet))


solution()
