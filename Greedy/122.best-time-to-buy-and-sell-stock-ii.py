#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        if len(prices) == 1:
            return 0
        Flag = (prices[1] - prices[0]) > 0
        before = prices[0]
        memo = 0
        if Flag :
            memo = prices[0]
        count = 0
        for price in prices:
            if (price > before) and( not Flag) :
                memo = before
                Flag = True
            elif price < before and Flag :
                count += before - memo
                memo = 0
                Flag = False
            before = price
        if Flag :
            count += prices[len(prices) - 1] - memo
        return count


# @lc code=end

