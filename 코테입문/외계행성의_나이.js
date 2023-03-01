function solution(age) {
  var answer = "";
  age = [...age.toString()];
  for (let char of age) {
    answer = answer + String.fromCharCode(parseInt(char) + 97);
  }
  return answer;
}
