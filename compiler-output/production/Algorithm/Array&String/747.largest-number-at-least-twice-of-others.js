/*
 * @lc app=leetcode id=747 lang=javascript
 *
 * [747] Largest Number At Least Twice of Others
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function (nums) {
  const sortedArr = [...nums].sort((a, b) => a - b);
  console.log(nums);
  if (sortedArr[nums.length - 1] < sortedArr[nums.length - 2] * 2) {
    return -1;
  } else {
    return nums.findIndex((num) => num == sortedArr[nums.length - 1]);
  }
};
// @lc code=end
