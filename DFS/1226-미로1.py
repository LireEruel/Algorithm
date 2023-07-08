
def print_map(_board,x,y):
    for k in range(16):
        for j in range(16):
            if k == x and y == j :
                print('★', end='')
            else:
                print(_board[k][j], end='')
        print('', end='\n')
    print('-------------------------')


def dfs(_board, x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    res = 0
    stack = [[x, y]]
    while len(stack):
        now = stack.pop()
        if _board[now[0]][now[1]] == '3':
            res = 1
            break
        _board[now[0]][now[1]] = '1'
        for index in range(4):
            nx = dx[index] + now[0]
            ny = dy[index] + now[1]
            if 0 <= nx < 16 and 0 <= ny < 16:
                if _board[nx][ny] != '1':
                    stack.append([nx, ny])
    return res


for test_case in range(1, 11):
    input()
    board = []
    start = [-1, -1]
    result = 0
    for i in range(16):
        board.append(list(input()))
        if '2' in board[i]:
            start[0] = i
            start[1] = board[i].index('2')

    if start[0] > -1:
        result = dfs(board, start[0], start[1])
    print('#%d %d' % (test_case, result))
