s = set(range(1,31))
for i in range(28):
    student = int(input())
    s.remove(student)
    
arr = list(s)
arr.sort()
print(arr[0])
print(arr[1])