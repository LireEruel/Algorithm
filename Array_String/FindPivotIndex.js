//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/

var pivotIndex = function (nums) {
  let left = 0;
  let right = nums.reduce((sum, curt) => sum + curt, 0);
  for (let i = 0; i < nums.length; i++) {
    right -= nums[i];
    if (left == right) {
      return i;
    } else {
      left += nums[i];
    }
  }
  return -1;
};
