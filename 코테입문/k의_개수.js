function solution(i, j, k) {
  var answer = 0;

  for (let start = i; start <= j; start++) {
    answer += [...start.toString()].filter((char) => char == k).length;
  }

  return answer;
}
