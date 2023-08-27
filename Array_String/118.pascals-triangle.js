/*
 * @lc app=leetcode id=118 lang=javascript
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
  const answer = [];
  answer[0] = [1];
  for (let i = 1; i < numRows; i++) {
    const row = [];
    row[0] = 1;
    row[i] = 1;

    for (let d = 1; d < i; d++) {
      row[d] = answer[i - 1][d - 1] + answer[i - 1][d];
    }
    answer.push(row);
  }
  return answer;
};

// @lc code=end
