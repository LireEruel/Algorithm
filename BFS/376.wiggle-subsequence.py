#
# @lc app=leetcode id=376 lang=python3
#
# [376] Wiggle Subsequence
#

# @lc code=start
class Solution:
    def wiggleMaxLength(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 1
        before = nums[1] - nums[0]
        count = 1 if before == 0 else 2
        for i in range(2,len(nums)):
            diff = nums[i] - nums[i-1]
            if (before <= 0 and diff > 0) or (before >= 0 and diff < 0):
                before = diff
                count += 1
        return count
# @lc code=end

