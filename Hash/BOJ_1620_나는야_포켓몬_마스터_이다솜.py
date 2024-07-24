# https://www.acmicpc.net/problem/1620
# 이름, 번호를 각각 키로 딕셔너리에 중복 저장해서 질문마다 꺼낸다.

import sys

n, m = map(int, sys.stdin.readline().split())
poke_dic = {}

for i in range(n):
    poke_name = sys.stdin.readline().split()[0]
    poke_dic[str(i + 1)] = poke_name
    poke_dic[poke_name] = str(i + 1)

for d in range(m):
    question = sys.stdin.readline().split()[0]
    print(poke_dic.get(question))
