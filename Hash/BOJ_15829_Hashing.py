L = int(input())
input_string = list(input())
answer = 0
M = 1
for n in input_string:
    answer += (ord(n) - 96) * M
    M *= 31
print(answer % 1234567891)
