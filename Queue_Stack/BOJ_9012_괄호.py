n = int(input())

for i in range(n):
    input_list = list(input())
    stack = []
    success = True
    for c in input_list:
        if c == "(":
            stack.append(c)
        else:
            if len(stack) > 0 and stack[-1] == "(":
                stack.pop()
            else:
                success = False
                break
    if success and len(stack) == 0:
        print("YES")
    else:
        print("NO")
