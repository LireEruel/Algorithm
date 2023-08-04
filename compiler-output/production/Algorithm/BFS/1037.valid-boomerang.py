#
# @lc app=leetcode id=1037 lang=python3
#
# [1037] Valid Boomerang
#

# @lc code=start
#
# @lc app=leetcode id=1037 lang=python
#
# [1037] Valid Boomerang
#

# @lc code=start
class Solution(object):
    def isBoomerang(self, points):
        """
        :type points: List[List[int]]
        :rtype: bool
        """
        
        x1, y1 = points[0][0], points[0][1]
        x2, y2 = points[1][0], points[1][1]
        x3, y3 = points[2][0], points[2][1]

        if x1 - x2 is 0 :
            slope12 = 90
        else :
            slope12 = (y1-y2) /( x1- x2)
    
        if x1 - x3 is 0 :
            slope13 = 90
        else :
            slope13 = (y1-y3) /( x1- x3)
        if x2 - x3 is 0 :
            slope23 = 90
        else :
            slope23 = (y2-y3) /( x2- x3)
        
        if slope12 == slope13 or slope13 == slope23 or slope12 == slope23 :
            return False
        else :
            return True
        
# @lc code=end

