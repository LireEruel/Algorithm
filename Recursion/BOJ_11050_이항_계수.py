# https://www.acmicpc.net/problem/11050
# 아이디어 : 재귀를 사용해서 수학 공식에 맞게 팩토리얼을 계산하여 풀었다.
# 아이디어 2 : 특히 fact 배열에 미리 값을 메모해놔서 같은 값을 두번 계산하지는 않게 최적화하였다.


def solution():
    N, K = map(int, input().split())
    fact = [1, 1, 2, 6]

    def getFact(value):
        if len(fact) - 1 >= value:
            return fact[value]
        else:
            return getFact(value - 1) * value

    print(int(getFact(N) / (getFact(K) * getFact(N - K))))


solution()
