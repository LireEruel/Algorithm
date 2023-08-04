//프로그래머스 > 코딩테스트 연습 > 스택/큐 > 올바른 괄호

function solution(s) {
  var answer = true;
  const stack = [];
  let sum = 0;
  if (s[0] == ")" || s.length % 2 !== 0 || s[s.length] == "(") return false;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "(") sum++;
    else sum--;
    if (sum < 0) return false;
  }

  return sum == 0 ? true : false;
}
