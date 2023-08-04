/*
 * @lc app=leetcode id=54 lang=javascript
 *
 * [54] Spiral Matrix
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function (matrix) {
  const result = [];
  let mode = 1;
  let top = 0;
  let right = 0;
  let bottom = 0;
  let left = 0;
  let m = 0;
  let n = 0;
  const M = matrix.length;
  const N = matrix[0].length;
  let count = 0;

  while (count < M * N) {
    result.push(matrix[m][n]);
    console.log(m, n);
    switch (mode) {
      case 1: {
        if (n == N - 1 - right) {
          mode = 2;
          m++;
          top++;
        } else {
          n++;
        }
        break;
      }
      case 2: {
        if (m == M - 1 - bottom) {
          mode = 3;
          n--;
          right++;
        } else {
          m++;
        }
        break;
      }
      case 3: {
        if (n == 0 + left) {
          mode = 4;
          m--;
          bottom++;
        } else {
          n--;
        }
        break;
      }
      case 4: {
        if (m == 0 + top) {
          mode = 1;
          n++;
          left++;
        } else {
          m--;
        }
        break;
      }
    }
    count++;
  }

  return result;
};
// @lc code=end
