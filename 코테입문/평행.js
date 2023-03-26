// /https://school.programmers.co.kr/learn/courses/30/lessons/120875

function solution(dots) {
  var answer = 0;
  const indexList = [
    [0, 1, 2, 3],
    [0, 2, 1, 3],
    [0, 3, 1, 2],
  ];

  indexList.forEach((indexs) => {
    const slope1 =
      Math.abs(dots[indexs[0]][0] - dots[indexs[1]][0]) /
      Math.abs(dots[indexs[0]][1] - dots[indexs[1]][1]);
    const slope2 =
      Math.abs(dots[indexs[2]][0] - dots[indexs[3]][0]) /
      Math.abs(dots[indexs[2]][1] - dots[indexs[3]][1]);

    if (slope1 == slope2) {
      answer = 1;
    }
  });

  return answer;
}
