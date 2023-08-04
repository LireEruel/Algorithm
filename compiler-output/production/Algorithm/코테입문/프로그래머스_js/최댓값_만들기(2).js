function solution(numbers) {
  var answer = 0;
  const sorted = numbers.sort((a, b) => a - b);

  const front = numbers[0] * numbers[1];
  const back = numbers[numbers.length - 2] * numbers[numbers.length - 1];

  return front > back ? front : back;
}
