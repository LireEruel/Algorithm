#
# @lc app=leetcode id=111 lang=python3
#
# [111] Minimum Depth of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        result = 0
        q = Queue()
        if root is None:
            return result
        q.put([root, 1])
        while q:
            curt = q.get()
            if (curt[0].left is None) and (curt[0].right is None):
                return curt[1]
            if curt[0].left is not None:
                q.put([curt[0].left, curt[1] + 1])
            if curt[0].right is not None:
                q.put([curt[0].right, curt[1] + 1])
        return result


# @lc code=end
