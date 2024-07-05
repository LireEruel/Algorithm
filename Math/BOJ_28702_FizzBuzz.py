numbers = [input(), input(), input()]

target_num = 0
for i in range(3):
    if numbers[i].isdecimal():
        target_num = int(numbers[i]) + 3 - i
        break

if target_num % 15 == 0:
    print("FizzBuzz")
elif target_num % 5 == 0:
    print("Buzz")
elif target_num % 3 == 0:
    print("Fizz")
else:
    print(target_num)
