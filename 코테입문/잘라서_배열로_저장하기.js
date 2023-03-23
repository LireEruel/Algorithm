function solution(my_str, n) {
  var answer = [];

  let index = 0;

  while (index < my_str.length) {
    let endIndex = index + n;
    if (endIndex > my_str.length) {
      endIndex = my_str.length;
    }
    answer.push(my_str.substring(index, endIndex));
    index += n;
  }
  return answer;
}

console.log(solution("1", 3)); //["abc1Ad", "dfggg4", "556b"]
