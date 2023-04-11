function solution(numbers, k) {
  let index = 0;
  for (i = 1; i < k; i++) {
    index += 2;
    if (index > numbers.length - 1) {
      index = index - numbers.length;
    }
  }
  return numbers[index];
}

// 좋은 풀이 :   return numbers[(--k*2)%numbers.length];

const testcaseList = [
  [[1, 2, 3, 4], 2, 3],
  [[1, 2, 3, 4, 5, 6], 5, 3],
  [[1, 2, 3], 3, 2],
  [
    [1, 2, 3, 4, 5, 6, 3, 7, 8, 9, 0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],
    30,
    15,
  ],
];

for (testcase of testcaseList) {
  const result = solution(testcase[0], testcase[1]);
  console.log(`input data : ${testcase[0]}  ${testcase[1]}`);
  console.log(`expected : ${testcase[2]}`);
  console.log(`actual : ${result}`);
  console.log(testcase[2] == result ? "success" : "failure");
}
