T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    result = n *4 +1
    count = 0
    for i in range (1, n):
        for d in range(n-1,0,-1):
            if i*i + d*d <= n*n :
                count += d
                break
    print('#%d %d' %(test_case, result + count * 4))