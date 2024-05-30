# https://www.acmicpc.net/problem/10809
# 아이디어 : 미리 map에 정보를 입력시켜놓고 최종적으로 알파벳들 전부 for문 한번 돌리면서 출력한다.

alphaPlaces = {}
word = input()
index = 0
for c in word:
    if ord(c) not in alphaPlaces:
        alphaPlaces[ord(c)] = index

    index += 1

for i in range(97, 123):
    print(-1 if i not in alphaPlaces else alphaPlaces[i], end=" ")
