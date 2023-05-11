#
# @lc app=leetcode id=872 lang=python3
#
# [872] Leaf-Similar Trees
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        leaves1 = self.dfs( root1, [])    
        leaves2 = self.dfs( root2, [])
        return leaves1 == leaves2
        
    def dfs (self, root, memo:list) :
        if root.left is None and root.right is None:
            memo.append(root.val)
        if root.left is not None :
            self.dfs(root.left, memo)
        if root.right is not None :
            self.dfs(root.right, memo)
        return memo
# @lc code=end

