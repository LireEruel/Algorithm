import sys

n, m = map(int, input().split())

sites = {}

for i in range(n):
    site, pw = sys.stdin.readline().split()
    sites[site] = pw

result = []
for i in range(m):
    target = sys.stdin.readline().strip()
    result.append(sites[target])

print("\n".join(result))
