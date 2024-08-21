# https://www.acmicpc.net/problem/11399
# 아이디어 : 정렬 한 뒤 더한다.

n = int(input())
p_list = list(map(int, input().split()))
p_list.sort()

answer = 0
for i in range(n):
    curt = p_list[i]
    answer += curt * (n - i)
print(answer)
