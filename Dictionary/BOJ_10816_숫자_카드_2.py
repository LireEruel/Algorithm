# https://www.acmicpc.net/problem/10816
# dict을 사용하여 쉽게 풀이

import sys

input = sys.stdin.readline
N = int(input())
card_list = list(map(int, input().split()))
M = int(input())
target_list = list(map(int, input().split()))
card_set = {}
for card in card_list:
    if card in card_set:
        card_set[card] += 1
    else:
        card_set[card] = 1

answer = []
for target in target_list:
    if target in card_set:
        answer.append(str(card_set[target]))
    else:
        answer.append("0")

print(" ".join(answer))
