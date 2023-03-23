//https://school.programmers.co.kr/learn/courses/30/lessons/120852

function solution(n) {
  const answer = new Set();

  let i = 1;
  let temp = n;
  while (i < temp) {
    i++;
    console.log(temp, i);
    if (temp % i == 0) {
      answer.add(i);

      temp = temp / i;
      i = 1;
    }
  }
  if (!answer.size) {
    answer.add(n);
  }
  return Array.from(answer);
}

console.log(solution(12)); // [2,3]
