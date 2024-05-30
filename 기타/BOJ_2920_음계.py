def solution():
    melodys = list(map(int, input().split()))
    flow = melodys[0] - melodys[1]
    if flow * flow != 1:
        # 애초에 맨 앞이 1씩 줄어들거나 커진게 아니라면 무조건 mixed이다.
        return print("mixed")
    result = "descending" if flow == 1 else "ascending"
    for i in range(1, len(melodys)):
        if melodys[i - 1] - melodys[i] != flow:
            result = "mixed"
            break
    print(result)


solution()
