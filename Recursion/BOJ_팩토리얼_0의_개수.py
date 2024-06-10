# https://www.acmicpc.net/problem/1676
# 아이디어 : 재귀함수로 팩토리얼을 계산하여 구현

fact = [1, 1, 2]


def get_fact(value):
    if len(fact) > value:
        return fact[value]
    else:
        fact.append(get_fact(value - 1) * value)
        return fact[value]


N = int(input())
n_fact = get_fact(N)
result = 0

while n_fact > 0:
    if n_fact % 10 == 0:
        result += 1
        n_fact //= 10
    else:
        break
print(result)
