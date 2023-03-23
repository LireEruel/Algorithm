//https://school.programmers.co.kr/learn/courses/30/lessons/120868

function solution(sides) {
  var answer = 0;
  const side1 = sides[0];
  const side2 = sides[1];
  for (let i = 1; i <= Math.max(...sides); i++) {
    if (side1 >= side2) {
      if (side1 < side2 + i) {
        answer++;
      }
    } else {
      if (side2 < side1 + i) {
        answer++;
      }
    }
  }
  answer += side1 + side2 - 1 - Math.max(...sides);

  return answer;
}

console.log(solution([1, 2]));
