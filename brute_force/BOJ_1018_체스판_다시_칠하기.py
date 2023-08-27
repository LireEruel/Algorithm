import copy


def checkCount(board, startX, startY):
    countW = 0
    w_board = copy.deepcopy(board)
    for x in range(startX, startX + 8):
        if x == len(w_board):
            break
        for y in range(startY, startY + 8):
            if y == len(w_board[0]):
                break
            if x == startX and y == startY:
                if w_board[startX][startY] == 'B':
                    countW += 1
                    w_board[startX][startY] = 'W'
            elif y == startY:
                if w_board[x - 1][y] == w_board[x][y]:
                    w_board[x][y] = "W" if w_board[x][y] == "B" else "B"
                    countW += 1
            else:
                if w_board[x][y - 1] == w_board[x][y]:
                    w_board[x][y] = "W" if w_board[x][y] == "B" else "B"
                    countW += 1
    countB = 0
    b_board = copy.deepcopy(board)
    for x in range(startX, startX + 8):
        if x == len(b_board):
            break
        for y in range(startY, startY + 8):
            if y == len(b_board[0]):
                break
            if x == startX and y == startY:
                if b_board[startX][startY] == 'W':
                    countB += 1
                    b_board[startX][startY] = 'B'
            elif y == startY:
                if b_board[x - 1][y] == b_board[x][y]:
                    b_board[x][y] = "W" if b_board[x][y] == "B" else "B"
                    countB += 1
            else:
                if b_board[x][y - 1] == b_board[x][y]:
                    b_board[x][y] = "W" if b_board[x][y] == "B" else "B"
                    countB += 1
    return countW if countW <= countB else countB


N, M = map(int, input().split())
board = []
minChange = -1
for r in range(N):
    board.append(list(input()))

for x in range(N - 7):
    for y in range(M - 7):
        temp = copy.deepcopy(board)
        count = checkCount(temp, x, y)
        if count < minChange or minChange == -1:
            minChange = count
print(minChange)
