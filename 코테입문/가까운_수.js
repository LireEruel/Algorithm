function solution(array, n) {
  array = array.sort((a, b) => a - b);
  array = array.sort((a, b) => (a - n) * (a - n) - (b - n) * (b - n));
  console.log(array);
  return array[0];
}
