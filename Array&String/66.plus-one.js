/*
 * @lc app=leetcode id=66 lang=javascript
 *
 * [66] Plus One
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
  let index = digits.length - 1;
  while (index > -1) {
    digits[index]++;
    if (digits[index] == 10) {
      digits[index] = 0;
      index--;
    } else {
      index = -1;
    }
  }
  if (digits[0] == 0) {
    digits.unshift("1");
  }
  return digits;
};
// @lc code=end
