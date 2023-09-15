T = int(input())

for i in range(T):
    a, b = map(int, input().split())
    curt = a
    list = [a % 10]
    for j in range(b):
        curt *= a
        curt %= 10
        if curt % 10 == a % 10:
            break
        else:
            list.append(curt)
    print(list[b % len(list) - 1])
