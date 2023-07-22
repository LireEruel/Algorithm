#
# @lc app=leetcode id=884 lang=python3
#
# [884] Uncommon Words from Two Sentences
#


# @lc code=start
class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        arr = set()
        s_list1 = s1.split(" ")
        s_list2 = s2.split(" ")
        for i in range(len(s_list1)):
            new_list = s_list1.copy()
            s = new_list.pop(i)
            if s not in new_list and s not in s_list2:
                arr.add(s)
        for i in range(len(s_list2)):
            new_list = s_list2.copy()
            s = new_list.pop(i)
            if s not in new_list and s not in s_list1:
                arr.add(s)
        return list(arr)


# @lc code=end
