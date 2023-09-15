N = int(input())
nums = list(map(int,input().split()))
max = nums[0]
min = nums[0]
for i in nums:
    if i < min :
        min = i
    if i > max :
        max = i

print(f"{min} {max}")