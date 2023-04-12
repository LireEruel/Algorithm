a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)

count = 0
for i in range(a):
    for j in range(b):
        for k in range(c):
            print(f'{i} {j} {k}')
            count += 1

print(count)