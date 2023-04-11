//https://school.programmers.co.kr/learn/courses/30/lessons/120884

function solution(chicken) {
  var answer = 0;
  let koophon = chicken;

  while (koophon > 9) {
    const temp = Math.floor(koophon / 10);
    answer += temp;
    koophon -= temp * 10;
    koophon += temp;
  }

  return answer;
}
