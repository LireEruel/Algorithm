N, M = map(int, input().split())

maxCard = 0
for i in range(N):
    minCard = min(list(map(int, input().split())))
    if minCard > maxCard:
        maxCard = minCard
print(maxCard)
