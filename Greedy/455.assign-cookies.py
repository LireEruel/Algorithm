#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: list[int], s: list[int]) -> int:
        if len(s) == 0 : 
            return 0
        child_index = 0
        cookie_index = 0
        g.sort()
        s.sort()

        while child_index < len(g) and cookie_index < len(s):
            if g[child_index] <= s[cookie_index]:
                child_index += 1
            cookie_index += 1
        return child_index

# @lc code=end

