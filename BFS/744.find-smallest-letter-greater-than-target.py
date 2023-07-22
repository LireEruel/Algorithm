#
# @lc app=leetcode id=744 lang=python3
#
# [744] Find Smallest Letter Greater Than Target
#


# @lc code=start
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        first = letters[0]
        letters.sort()
        for letter in letters:
            if letter > target:
                return letter
        return first


# @lc code=end
