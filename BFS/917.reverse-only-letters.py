#
# @lc app=leetcode id=917 lang=python
#
# [917] Reverse Only Letters
#

# @lc code=start

class Solution(object):
    def reverseOnlyLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        reversed = s[::-1]
        index = 0
        result = ''
        for char in s:
            if char.isalpha():
                while(not reversed[index].isalpha()):
                    index +=1
                result += reversed[index]
                index += 1
            else :
                result += char

        return result
# @lc code=end

