function solution(n) {
  var answer = 0;
  for (let i = 1; i <= n; i++) {
    answer++;
    while (answer % 3 == 0 || answer.toString().search(3) > -1) {
      answer++;
    }
  }
  return answer;
}
