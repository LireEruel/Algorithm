//https://school.programmers.co.kr/learn/courses/30/lessons/120860

function solution(dots) {
  dots.sort();
  let answer = (dots[0][1] - dots[1][1]) * (dots[0][0] - dots[2][0]);
  if (answer < 0) answer *= -1;
  return answer;
}
