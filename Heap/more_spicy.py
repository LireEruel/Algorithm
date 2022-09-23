#프로그래머스 > 코딩테스트 연습 > 스택/큐 > 더 맵게

import heapq

def solution(scoville, K):
    cnt = 0
    heapq.heapify(scoville)
    while(len(scoville) > 1) : 
        if scoville[0] > K :
            print(scoville[0])
            return cnt
        heapq.heappush(scoville, heapq.heappop(scoville) + heapq.heappop(scoville) * 2)
        cnt += 1
    return -1 if scoville[0] < K else cnt
