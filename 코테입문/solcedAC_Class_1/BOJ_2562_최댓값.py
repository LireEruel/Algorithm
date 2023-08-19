max = 0
index = -1
for i in range(1, 10):
    num = int(input())
    if num > max:
        index = i
        max = num
print(max)
print(index)
