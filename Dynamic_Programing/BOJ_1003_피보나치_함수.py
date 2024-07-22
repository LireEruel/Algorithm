# https://www.acmicpc.net/problem/1003
# 아이디어 : 어차피 N이 40이 최대이므로 0~40까지 미리 다 구해놓는다.
# 정답의 원리는 n-1, n-2에 출력된 개수의 합이므로 한번 쭉 만들어놓는다면
# 시간은 O(N)이다. 시간이 0.25초라도 아주 널널하다!

fibo_list = [[1, 0], [0, 1]]


for i in range(2, 41):
    fibo_list.append(
        [fibo_list[-1][0] + fibo_list[-2][0], fibo_list[-1][1] + fibo_list[-2][1]]
    )

TC = int(input())
for tc in range(TC):
    n = int(input())
    print(fibo_list[n][0], fibo_list[n][1])
