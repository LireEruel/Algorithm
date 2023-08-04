//https://school.programmers.co.kr/learn/courses/30/lessons/120853

function solution(s) {
  var answer = 0;
  s.split(" ").forEach((char, index, list) => {
    if (
      Number.isInteger(+char) &&
      (s.length - 1 == index || list[index + 1] !== "Z")
    )
      answer += +char;
  });
  return answer;
}

console.log(solution("1 2 Z 3")); //4
