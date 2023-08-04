T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    list_size = int(input())
    board = []
    for i in range(list_size):
        board.append(list(input().split()))
    map_90 = list(zip(*board[::-1]))
    map_180 = list(zip(*map_90[::-1]))
    map_270 = list(zip(*map_180[::-1]))

    print(f"#{test_case}")
    for row in range(list_size):
        print(f"{''.join(map_90[row])} {''.join(map_180[row])} {''.join(map_270[row])}")
