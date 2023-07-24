N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for i in range(M):
    start, point = map(int, input().split())
    if point not in graph[start]:  # 중복 간선 방지
        graph[start].append(point)
    if start not in graph[point]:  # 양방향 간선이므로 두 정점에 모두 추가
        graph[point].append(start)


def dfs():
    visited = []
    stack = [V]
    while stack:
        now = stack.pop()
        if now not in visited:
            visited.append(now)
            stack.extend(sorted(graph[now], reverse=True))  # 정점들을 내림차순으로 스택에 추가
    return " ".join(str(element) for element in visited)


def bfs():
    visited = []
    queue = [V]
    while queue:
        now = queue.pop(0)
        if now not in visited:
            visited.append(now)
            queue.extend(sorted(graph[now]))  # 정점들을 오름차순으로 큐에 추가
    return " ".join(str(element) for element in visited)


print(dfs())
print(bfs())
