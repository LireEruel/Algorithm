# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
      아래의 구문은 input.txt 를 read only 형식으로 연 후,
      앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
      여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
      아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.

      따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
      아래 구문을 사용하기 위해서는 import sys가 필요합니다.

      단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
def checkShortest(map, bfs_map, x, y):
    ways = [[-1, 0], [0, -1], [0, 1], [1,0]]
    best_way = None
    min = None
    is_updated = False
    #print('checking', x, y)
    for way in ways :
        if x + way[0] >= 0 and y + way[1] >= 0 and len(bfs_map) > y + way[1] and len(bfs_map[y + way[1]]) > x + way[0] :
            cost = bfs_map[y + way[1]][x+way[0]] + map[y][x]
            if best_way == None or cost < min:
                best_way = way
                min = cost
    if  len(bfs_map) <= y  :
        bfs_map.append([min])            
        is_updated = True
    elif len(bfs_map[y]) <= x:
        bfs_map[y].append(min)
        is_updated = True
    elif bfs_map[y][x] > min :
        bfs_map[y][x] = min
        is_updated = True
    
    if is_updated :
        for way in ways :
            if x + way[0] >= 0 and y + way[1] >= 0 and len(bfs_map) > y + way[1] and len(bfs_map[y+way[1]]) > x + way[0] :
                checkShortest(map, bfs_map, x + way[0], y + way[1])
        
K = int(input())

for tast_case in range(1, K+1):
    size = int(input())
    map = []
    bfs_map = [[0]]
    for i in range(size):
        map.append([])
        row = input()
        for c in row : 
            map[i].append(int(c))
    for y in range(size):
        for x in range(size):
            if x == 0 and y == 0 :
                continue
            elif x  == 0 :
                bfs_map.append([bfs_map[y-1][x] + map[y][x]])
            elif y == 0 :
                bfs_map[0].append(bfs_map[y][x-1] + map[y][x])
            else :
                checkShortest(map, bfs_map, x, y)
            #print('bfs_map : ', bfs_map)
    print('#%d %d'%(tast_case, bfs_map[size-1][size-1] ))
