T = int(input())

for test_case in range(1, T + 1):
    print('#%d %d' %(test_case, max( list(map(int,input().split())))))
