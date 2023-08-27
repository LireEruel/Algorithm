N = int(input())

arr = []
for i in range(N):
    A, B = map(int, input().split())
    arr.append([A,B])

arr.sort()
for nums in arr:
    print(nums[0], nums[1])