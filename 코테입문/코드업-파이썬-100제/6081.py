def trans10to16(value) :
    result = ''
    num_value = value
    while num_value > 0 :
        remainder = num_value % 16
        num_value = num_value // 16
        if remainder > 9 : 
            remainder = chr(remainder + 55)
        result = str(remainder) + result
    return result


input = input()
input_num =  ord(input)- 55
# print(trans10to16(16))
for i in range(1, 16) :
    result = ''

    print(result + input+ '*'+ trans10to16(i) + '='+ trans10to16(input_num * i ))