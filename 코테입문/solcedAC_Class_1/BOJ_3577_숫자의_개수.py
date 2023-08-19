nums = []
for i in range(3):
    nums.append(int(input()))
sum = 1
for num in nums:
    sum *= num
s = str(sum)
arr = [0] * 10
for c in s:
    arr[int(c)] += 1

for num in arr:
    print(num, end="\n")
