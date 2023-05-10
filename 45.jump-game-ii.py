#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#

# @lc code=start
class Solution:
    def jump(self, nums: list[int]) -> int:
        target = len(nums) -1
        count = 0
        while (target > 0) :
            for d in range(0 , target):
                if target <= d + nums[d] : 
                    target = d
                    count += 1
                    break
        return count
# @lc code=end

print(Solution.jump(3, [1,2,3]))