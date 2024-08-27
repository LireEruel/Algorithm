# https://www.acmicpc.net/problem/2606
# 아이디어 : BFS 활용
import sys
from collections import deque

input = sys.stdin.readline
computer_count = int(input())
line_count = int(input())
computers = [[]]
for i in range(computer_count):
    computers.append([])

for i in range(line_count):
    a, b = map(int, input().strip().split())
    computers[a].append(b)
    computers[b].append(a)

queue = deque([1])
answer = -1
visits = set({1})

while queue:
    answer += 1
    curt_computer = queue.popleft()

    for computer in computers[curt_computer]:
        if computer not in visits:
            queue.append(computer)
            visits.add(computer)
print(answer)
