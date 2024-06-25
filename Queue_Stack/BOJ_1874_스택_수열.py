# https://www.acmicpc.net/problem/1874
# 아이디어 : target이 현재 i보다 큰 수라면 같아질 때까지 push한다.
# 그 후 stack의 top이 target과 같다면 pop하고 아니라면 valid를 해제한다.

n = int(input())
valid = True
queue = []

index = 0
i = 0
answer = []
while valid and i <= n and index < n:
    index += 1
    target = int(input())
    while i < target:
        i += 1
        queue.append(i)
        answer.append("+")
    if queue[-1] == target:
        queue.pop(-1)
        answer.append("-")
    else:
        valid = False
if valid:
    print("\n".join(answer))
else:
    print("NO")
