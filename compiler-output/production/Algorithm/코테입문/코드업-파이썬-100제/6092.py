memo = [0]*23
count = int(input())
arr = list(map(int, input().split()))

for num in arr :
    memo[num-1] += 1

print(' '.join(map(str, memo)))