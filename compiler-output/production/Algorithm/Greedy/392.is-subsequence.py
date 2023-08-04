#
# @lc app=leetcode id=392 lang=python3
#
# [392] Is Subsequence
#

# @lc code=start
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        index = 0
        if len(s) > len(t) :
            return False
        if len(s) == 0 :
            return True
        for char in t :
            if char == s[index] :
                index +=1
                if index >= len(s) :
                    return True
        return False
        
# @lc code=end

