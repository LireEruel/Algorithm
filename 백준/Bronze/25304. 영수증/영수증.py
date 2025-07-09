cost_sum = int(input())
n = int(input())
curt_cost = 0

for i in range(n):
    cost, nv = map(int, input().split())
    curt_cost += cost * nv
    
if curt_cost == cost_sum:
    print("Yes")
else :
    print("No")