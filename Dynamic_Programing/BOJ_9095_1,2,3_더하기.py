# https://www.acmicpc.net/problem/9095

t = int(input())
solutions = [0, 1, 2, 4]

for i in range(4, 11):
    solutions.append(solutions[i - 3] + solutions[i - 2] + solutions[i - 1])
for i in range(t):
    n = int(input())
    print(solutions[n])
