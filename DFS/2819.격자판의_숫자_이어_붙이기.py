def dfs(number, x, y):
    if len(number) == 7:
        result.add(number)
        return
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < 4 and 0 <= ny < 4:
            dfs(number + maps[nx][ny], nx, ny)
    return


T = int(input())

# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    maps = [input().split() for _ in range(4)]
    result = set()
    for i in range(4):
        for d in range(4):
            dfs("", i, d)
    print("#{} {}".format(test_case, len(result)))
