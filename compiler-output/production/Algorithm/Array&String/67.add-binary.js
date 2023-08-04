/*
 * @lc app=leetcode id=67 lang=javascript
 *
 * [67] Add Binary
 */

// @lc code=start
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function (a, b) {
  let temp = 0;
  const length = a.length >= b.length ? a.length : b.length;
  let answer = [];
  a = [...a];
  b = [...b];
  for (let i = 0; i < length; i++) {
    let curt_a = parseInt(a.pop());
    let curt_b = parseInt(b.pop());
    if (Number.isNaN(curt_a)) curt_a = 0;
    if (Number.isNaN(curt_b)) curt_b = 0;
    let count = temp + curt_a + curt_b;
    if (count > 1) {
      temp = 1;
    } else {
      temp = 0;
    }
    answer.unshift(count % 2);
  }
  if (temp) answer.unshift("1");
  return answer.join("");
};
// @lc code=end
