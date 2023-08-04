#
# @lc app=leetcode id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def array_to_tree(left, right):
            if left > right:
                return None
            nonlocal preorder_index
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)
            preorder_index += 1

            root.left = array_to_tree(left, inorder_index_map[root_value] - 1)
            root.right = array_to_tree(inorder_index_map[root_value] + 1, right)

            return root

        preorder_index = 0
        inorder_index_map = {}

        for index, value in enumerate(inorder):
            inorder_index_map[value] = index
        return array_to_tree(0, len(preorder) - 1)


# @lc code=end
