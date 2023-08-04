T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    answer = 1
    board = [] * 9
    for i in range(9):
        board.append(list(map(int, input().split())))
    # board 완성
    # 가로줄 검사
    for i in range(9):
        if answer:
            array = [0] * 10
            for d in range(9):
                if array[board[i][d]] == 0:
                    array[board[i][d]] = 1
                else:
                    answer = 0
                    break
        else:
            break

    # 세로줄 검사
    if answer:
        for i in range(9):
            if answer:
                array = [0] * 10
                for d in range(9):
                    if array[board[d][i]] == 0:
                        array[board[d][i]] = 1
                    else:
                        answer = 0
                        break
            else:
                break

    # 3*3 cube 검사

    if answer:
        for cubeRow in range(3):
            for cubeCol in range(3):
                if answer:
                    array = [0] * 10
                    for i in range(3):
                        for d in range(3):
                            if array[board[cubeRow*3 + i][cubeCol*3 + d]] == 0:
                                array[board[cubeRow*3 + i][cubeCol*3 + d]] = 1
                            else:
                                answer = 0
                                break
                else:
                    break

    print('#%d %d' % (test_case, answer))