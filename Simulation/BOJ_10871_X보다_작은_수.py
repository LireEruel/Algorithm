# https://www.acmicpc.net/problem/10871
# 아이디어 : 그냥 if문 돌린 것 뿐...

N, X = map(int, input().split())
num_list = list(map(int, input().split()))
answer = []
for num in num_list:
    if num < X:
        answer.append(str(num))

print(" ".join(answer))
