#
# @lc app=leetcode id=1047 lang=python3
#
# [1047] Remove All Adjacent Duplicates In String
#

# @lc code=start
class Solution:
    def removeDuplicates(self, s: str) -> str:
        charSet = []
        for c in s:
            if len(charSet) > 0:
                if(charSet[-1] == c):
                    charSet.pop()
                else:
                    charSet.append(c)
            else :
                charSet.append(c)
        return ''.join(charSet)           
        
        


# @lc code=end

