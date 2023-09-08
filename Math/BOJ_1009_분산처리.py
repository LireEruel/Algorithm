T = int(input())

for i in range(T):
    a, b = map(int, input().split())
    curt = a
    list = [a]
    for j in range(b):
        curt *= a
        if curt % 10 == a:
            break
        else:
            list.append(curt % 10)
    print(list[b % len(list) - 1])


# 이거 못풀음 ㅠㅠ
