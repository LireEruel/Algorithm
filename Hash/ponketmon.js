function solution(nums) {
  const set = new Set(nums);
  if (parseInt(nums.length / 2) > set.size) return set.size;
  else return parseInt(nums.length / 2);
}
