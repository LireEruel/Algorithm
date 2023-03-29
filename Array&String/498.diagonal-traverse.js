/*
 * @lc app=leetcode id=498 lang=javascript
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @return {number[]}
 */
var findDiagonalOrder = function (mat) {
  let upMode = true;
  let result = [];
  const M = mat.length;
  const N = mat[0].length;
  const total = M * N;

  let count = 0;
  let m = 0;
  let n = 0;

  while (count < total) {
    result.push(mat[m][n]);

    if (upMode) {
      if (m == 0 && n < N - 1) {
        upMode = !upMode;
        n++;
      } else if (n == N - 1) {
        upMode = !upMode;
        m++;
      } else {
        m--;
        n++;
      }
    } else {
      if (m == M - 1 && n < N - 1) {
        upMode = !upMode;
        n++;
      } else if (n == 0) {
        upMode = !upMode;
        m++;
      } else {
        m++;
        n--;
      }
    }
    count++;
  }
  return result;
};
// @lc code=end
