// leetCode > 496. Next Greater Element I

var nextGreaterElement = function (nums1, nums2) {
  const resultArray = [];

  nums1.forEach((target) => {
    const targetIndex = nums2.findIndex((number) => number == target);
    let result = -1;
    for (let i = targetIndex + 1; i < nums2.length; i++) {
      if (nums2[i] > target) {
        result = nums2[i];
        break;
      }
    }
    resultArray.push(result);
  });

  return resultArray;
};
