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
  let m = 0;
  let n = 0;

  while (mat[m] !== undefined && mat[m][n] !== undefined) {
    result.push(mat[m][n]);

    if (upMode) {
      m--;
      n++;
      if (!mat[m] || !mat[m][n]) {
        upMode = false;

        if (mat[0].length - 1 < n) {
          n--;
          m += 2;
        } else {
          m++;
        }
      }
    } else {
      m++;
      n--;
      if (!mat[m] || !mat[m][n]) {
        upMode = true;
        if (m > mat.length - 1) {
          m--;
          n += 2;
        } else {
          n++;
        }
      }
    }
  }
  return result;
};
// @lc code=end
