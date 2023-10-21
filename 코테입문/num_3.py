from queue import Queue
from copy import deepcopy

n = 13
k = 5
capitals = [1,9]
edges = [[1,2,3],[2,4,4],[3,2,1],[1,6,6],[1,5,6],[1,7,6],[6,7,2],[5,7,5],[7,8,2],[9,7,3],[9,10,6],[9,11,3],[11,12,2],[11,13,4]]

# n = 7
# k = 10
# capitals = [2]
# edges = [[1,2,11],[1,5,1],[2,4,5],[5,4,4],[4,3,7],[4,6,8],[4,7,3],[6,7,3]]


def sudoguan(start_city):
    visit_city = [start_city]

    queue = Queue()
    # 현재 위치, 지금까지의 cost, 방문했던 위치 저장
    queue.put((start_city,0,visit_city))

    while not queue.empty():
        cur_city, cur_cost, cur_visit_city = queue.get(0)

        for next_city in range(n):
            # 이미 방문했던 도시
            if next_city in cur_visit_city:
                continue

            # 연결되지 않은 도시
            if map[cur_city][next_city] == 0:
                continue

            # 비용이 초과하는 도시
            if map[cur_city][next_city] + cur_cost > k:
                continue

            # 다음 도시가 수도이면서, 비용이 안초과하는 경우 수도권 확정
            if next_city+1 in capitals and map[cur_city][next_city] + cur_cost <= k:
                return True

            next_visit_city = deepcopy(cur_visit_city)
            next_visit_city.append(next_city)
            queue.put((next_city,map[cur_city][next_city] + cur_cost, next_visit_city))

    return False

# 초기 맵 생성
map = []
for i in range(n):
    tmp =  []
    for j in range(n):
        tmp.append(0)
    map.append(tmp)

# edge 탐색하며, map 구현
for edge in edges:
    a = edge[0]
    b = edge[1]
    cost = edge[2]

    map[a-1][b-1] = cost
    map[b-1][a-1] = cost

result = []
for city in range(n):
    if sudoguan(city) is True:
        result.append(city+1)

print(result)