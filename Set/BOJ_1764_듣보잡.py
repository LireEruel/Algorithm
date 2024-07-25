import sys

n, m = map(int, sys.stdin.readline().split())
never_seens = set()
answer = []
for i in range(n):
    never_seens.add(sys.stdin.readline())

for i in range(m):
    name = sys.stdin.readline()
    if name in never_seens:
        answer.append(name)
answer.sort()
print(len(answer))
print("".join(answer))
