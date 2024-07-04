TC = int(input())

queue = []
for testcase in range(TC):
    value = int(input())
    if value == 0:
        queue.pop()
    else:
        queue.append(value)
print(sum(queue))
