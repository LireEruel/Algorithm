current_num = 666
count = 1

target = int(input())

while count < target:
    current_num = current_num + 1
    if str(current_num).find("666") > -1:
        count = count + 1

print(current_num)
