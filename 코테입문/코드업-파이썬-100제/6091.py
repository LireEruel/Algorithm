a, b, c = map(int, input().split())

result = max(a, b, c)

while result % a or result % b or result % c :
    result += 1

print(result)