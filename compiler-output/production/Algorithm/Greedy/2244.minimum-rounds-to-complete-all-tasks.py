#
# @lc app=leetcode id=2244 lang=python3
#
# [2244] Minimum Rounds to Complete All Tasks
#

# @lc code=start
import numpy as np

class Solution:
    def minimumRounds(self, tasks: list[int]) -> int:
        tasks.sort()
        round = 0
        now = 0
        index = -1
        tasks_counts = []
        
        for task in tasks:
            if now == task :
                tasks_counts[index] += 1
            else :
                now = task
                index += 1
                tasks_counts.append(1)
        for count in tasks_counts : 
            if count < 2 :
                return -1
            else :
                left = count % 3
                if left == 0 :
                    round += count // 3
                elif left == 1 :

                    round += (count // 3 - 1 ) + 2
                else :
                    round += count // 3 + 1
        return round
# @lc code=end
    
