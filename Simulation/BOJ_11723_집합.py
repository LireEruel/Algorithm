import sys

nums = set()

m = int(input())
for i in range(m):
    parsed_str = sys.stdin.readline().split()
    oper = parsed_str[0]
    if oper == "all":
        nums = set(
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        )
        continue
    if oper == "empty":
        nums = set()
        continue
    value = int(parsed_str[1])
    if oper == "remove":
        nums.discard(value)
    if oper == "check":
        if value in nums:
            print(1)
        else:
            print(0)
    if oper == "toggle":
        if value in nums:
            nums.discard(value)
        else:
            nums.add(value)
    if oper == "add":
        nums.add(value)
