
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
    
