T = int(input())
for testcase in range(1, T+1) :
    size, power = map(int, input().split())
    board = []
    for i in range(size):
        board.append(list(map(int, input().split())))
    catch_max = 0
    plus_dx = [1, -1, 0, 0]
    plus_dy = [0, 0, 1, -1]
    cross_dx = [1, 1, -1,-1]
    cross_dy = [1, -1, 1, -1]

    for x in range(size):
        for y in range(size):
            plus_count = board[x][y]
            cross_count = board[x][y]

            for p in range(1, power):
                for d in range(4):
                    px = x + plus_dx[d] * p
                    py = y + plus_dy[d] * p
                    cx = x + cross_dx[d] * p
                    cy = y + cross_dy[d] * p

                    if 0 <= px < size and 0 <= py < size :
                        plus_count += board[px][py]
                    if 0 <= cx < size and 0 <= cy < size:
                        cross_count += board[cx][cy]

            if catch_max < plus_count:
                catch_max = plus_count
            if catch_max < cross_count:
                catch_max = cross_count
    print(f'#{testcase} {catch_max}')

