# 층 별로 몇개가 있는지 세어본다.
# 각 층별로 가능한지 체크하고 시간과 땅의 높이 체크한다.
import sys

input = sys.stdin.readline
map_dic = {}

N, M, B = map(int, input().split())

for i in range(N):
    line = list(map(int, input().split()))
    for ground in line:
        if ground in map_dic:
            map_dic[ground] += 1
        else:
            map_dic[ground] = 1

min_time = -1
target_height = 0
for target in range(min(map_dic), max(map_dic) + 1):
    # print(target)
    have_to_dig = 0
    have_to_put = 0
    for curt in map_dic:
        if curt < target:
            have_to_put += (target - curt) * map_dic[curt]
        elif curt > target:
            have_to_dig += (curt - target) * map_dic[curt]
    # print(target)
    # print("have_to_dig", have_to_dig)
    # print("have_to_put", have_to_put)
    spent_time = have_to_dig * 2 + have_to_put
    if have_to_dig + B < have_to_put:  # 빈 공간에 채울 재료가 부족한 경우
        continue
    elif (
        min_time < 0
        or min_time > spent_time
        or (min_time == spent_time and target_height < target)
    ):
        min_time = spent_time
        target_height = target

print(min_time, target_height)
# print(map_dic)
