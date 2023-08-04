#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#

# @lc code=start
class Solution:
    def canJump(self, nums: list[int]) -> bool:
        target = len(nums) -1
        while (target > 0) :    
            print(target)      
            for d in range(target -1 , -1, -1):
                print(target, d, nums[d])
                if target <= d + nums[d] : 
                    target = d
                    break
                if d == 0:
                    return False
        return True

# @lc code=end

