function solution(num_list, n) {
  var answer = [];
  let memo = [];
  for (let i of num_list) {
    memo.push(i);
    if (memo.length == n) {
      answer.push(memo);
      memo = [];
    }
  }

  return answer;
}
