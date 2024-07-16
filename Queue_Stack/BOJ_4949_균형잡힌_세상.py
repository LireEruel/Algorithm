while True:
    valid = True
    char_list = list(input())
    stack = []
    if len(char_list) == 1 and char_list[0] == ".":
        break
    if len(char_list) == 0 or char_list[-1] != ".":
        valid = False
    else:
        for char in char_list:
            if char == "(" or char == "[":
                stack.append(char)
            elif char == ")":
                if len(stack) > 0 and stack[-1] == "(":
                    stack.pop()
                else:
                    valid = False
            elif char == "]":
                if len(stack) > 0 and stack[-1] == "[":
                    stack.pop()
                else:
                    valid = False
    if stack:
        valid = False
    if valid:
        print("yes")
    else:
        print("no")
