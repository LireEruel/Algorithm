/*
 * @lc app=leetcode id=1379 lang=javascript
 *
 * [1379] Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} original
 * @param {TreeNode} cloned
 * @param {TreeNode} target
 * @return {TreeNode}
 */

var getTargetCopy = function (original, cloned, target) {
  let answer;
  function travel(o, c) {
    if (o) {
      if (o == target) answer = c;
      travel(o.left, c.left);
      travel(o.right, c.right);
    }
  }
  travel(original, cloned, target);
  return answer;
};
// @lc code=end
