# https://www.acmicpc.net/problem/1966
TC = int(input())

for tc in range(TC):
    n, m = map(int, input().split())

    documents = list(map(int, input().split()))

    order = 1
    index = 0

    while True:
        if index == n:
            index = 0
        document = documents[index]
        if document != 0 and document == max(documents):
            documents[index] = 0
            if index == m:
                break
            else:
                order += 1
        index += 1
    print(order)
