import math

N = int(input())
long_count = math.ceil(N / 4)
result = ""
for i in range(long_count):
    result += "long "
result += "int"
print(result)
