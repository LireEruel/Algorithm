#
# @lc app=leetcode id=316 lang=python3
#
# [316] Remove Duplicate Letters
#

# @lc code=start
from collections import Counter


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        if len(s) == 1:
            return s
        stack = []
        copy = list(s)
        for c in s:
            del copy[0]
            counter = Counter(copy)
            if len(stack) == 0: 
                stack.append(c)
            elif c in stack:
                continue
            else:
                while len(stack) > 0 :                   
                    top = stack[-1]
                    if counter[top] == 0:
                        if c not in stack:
                            stack.append(c)
                        break
                    elif top >= c :
                        stack.pop()
                    else :
                        print(stack, c not in stack)
                        if c not in stack:
                            stack.append(c)
                        break
                if len(stack) == 0: 
                    stack.append(c)
        return ''.join(stack)

# @lc code=end

