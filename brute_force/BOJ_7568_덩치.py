N = int(input())
peoples = []
ranks = []

for i in range(N):
    x, y = map(int, input().split())
    peoples.append([x, y])

answer = []
people_index = 0
for i in range(N):
    count = 1
    for j in range(N):
        if peoples[i][0] < peoples[j][0] and peoples[i][1] < peoples[j][1]:
            count += 1
    answer.append(count)

for d in answer:
    print(d, end=" ")
