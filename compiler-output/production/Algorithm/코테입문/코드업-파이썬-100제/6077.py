n = int(input())
count = 0
for i in range(n+1):
    if(not i%2):
        count += i
print(count)