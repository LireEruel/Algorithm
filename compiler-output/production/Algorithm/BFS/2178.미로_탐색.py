from collections import deque

N, M = map(int, input().split())

board = []
queue = deque([[0, 0, 1]])
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(N):
    board.append(list(input()))

result = -1
while queue:
    now = queue.popleft()
    x = now[0]
    y = now[1]
    cost = now[2]
    if x == (N - 1) and y == (M - 1):
        result = cost
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == "1":
            queue.append([nx, ny, cost + 1])
            board[nx][ny] = "0"
print(result)
