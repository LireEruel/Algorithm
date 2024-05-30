## https://www.acmicpc.net/problem/2884
# 아이디어 : 그냥 분에서 45 빼고 숫자 이상하지 않게 바꾸기

MAX_HOUR = 23
MAX_MINUTE = 59

# 시간 입력 받기
H, M = map(int, input().split())

# 45분을 뺀다
M = M - 45

# 분(M)이 음수인 경우 시간 조정
if M < 0:
    H = H - 1  # 시간에서 1시간을 빼고
    M = MAX_MINUTE + M + 1  # 분을 조정

# 시간(H)이 음수인 경우 하루 뒤로 넘어감
if H < 0:
    H = MAX_HOUR

# 최종 시간 출력
print(H, M)
