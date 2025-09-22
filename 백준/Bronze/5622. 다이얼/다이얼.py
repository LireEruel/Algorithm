str_list = list(input())

result = 0
for s in str_list:
    ord_value = ord(s)
    if ord_value < 68:
        result += 3
    elif ord_value < 71:
        result += 4
    elif ord_value < 74:
        result += 5
    elif ord_value < 77:
        result += 6
    elif ord_value < 80:
        result += 7
    elif ord_value < 84:
        result += 8
    elif ord_value < 87:
        result += 9
    elif ord_value < 91:
        result += 10
    else:
        result += 11
print(result)