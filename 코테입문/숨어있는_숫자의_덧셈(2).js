function solution(my_string) {
  var answer = 0;
  my_string = [...my_string];
  let readNumberFlag = false;
  let number = "";
  for (const char of my_string) {
    if (Number.isInteger(parseInt(char))) {
      number += char;
      readNumberFlag = true;
    } else if (readNumberFlag) {
      readNumberFlag = false;
      answer += parseInt(number);
      number = "";
    }
  }
  return answer;
}

// 좋은 풀이
function solution(my_string) {
  return my_string
    .toLowerCase()
    .replace(/[a-z]/g, " ")
    .split(" ")
    .map((v) => v * 1)
    .reduce((a, b) => a + b);
}
