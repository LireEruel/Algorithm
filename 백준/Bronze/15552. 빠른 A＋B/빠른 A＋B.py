import sys

input = sys.stdin.readline
output = []
N = int(input())
for i in range(N):
    A, B = map(int, input().split())
    output.append(str(A + B))
print("\n".join(output))
