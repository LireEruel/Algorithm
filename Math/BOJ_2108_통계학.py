# https://www.acmicpc.net/problem/2108
EPS = 1e-9
N = int(input())
sum = 0
num_dic = {}
num_list = []

num_mode = []
mode_max = 1
for i in range(N):
    num = int(input())
    sum += num
    num_list.append(num)
    if num in num_dic:
        num_dic[num] += 1
    else:
        num_dic[num] = 1

    if not num_mode:
        num_mode = [num]
    elif num_dic[num] > mode_max:
        num_mode = [num]
        mode_max = num_dic[num]
    elif mode_max == num_dic[num] and num not in num_mode:
        num_mode.append(num)
    # print(num_dic)

num_list.sort()
num_mode.sort()
mode = num_mode[0] if len(num_mode) < 2 else num_mode[1]
# print("==========================")
print(round(sum / N + EPS))
print(num_list[N // 2])
print(mode)
print(num_list[-1] - num_list[0])
