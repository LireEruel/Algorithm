#
# @lc app=leetcode id=100 lang=python3
#
# [100] Same Tree
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        result = True
        p_stack = []
        q_stack = []

        if p is not None and q is not None:
            p_stack.append(p)
            q_stack.append(q)
        elif (p is None and q is not None) or (p is not None and q is None):
            result = False
        while p_stack and result:
            _p = p_stack.pop()
            _q = q_stack.pop()
            if _p.val != _q.val:
                result = False

            if _p.left is not None and _q.left is not None:
                p_stack.append(_p.left)
                q_stack.append(_q.left)
            elif (_p.left is None and _q.left is not None) or (
                _p.left is not None and _q.left is None
            ):
                result = False
            if _p.right is not None and _q.right is not None:
                p_stack.append(_p.right)
                q_stack.append(_q.right)
            elif (_p.right is None and _q.right is not None) or (
                _p.right is not None and _q.left is None
            ):
                result = False

        return result


# @lc code=end
