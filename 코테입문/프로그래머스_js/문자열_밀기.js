function solution(A, B) {
  var answer = 0;
  let rightSide = [...A];
  while (rightSide.join("") !== B && answer < A.length) {
    answer++;
    let temp = rightSide.pop();
    rightSide.unshift(temp);
  }
  if (answer >= A.length) {
    answer = -1;
  }
  return answer;
}
