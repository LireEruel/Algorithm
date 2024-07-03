apartment = []


def getResident(k, n):
    answer = 0
    if k != 0 and len(apartment) >= k and len(apartment[k]) > n:
        return apartment[k][n]
    elif k == 0:
        answer = n
    else:
        for i in range(0, n + 1):
            answer += getResident(k - 1, i)
    if len(apartment) <= k:
        apartment.append([])
    apartment[k].append(answer)
    return answer


TC = int(input())
for tc in range(TC):
    apartment = []
    k = int(input())
    n = int(input())
    print(getResident(k, n))

# print(getResident(10, 14))
