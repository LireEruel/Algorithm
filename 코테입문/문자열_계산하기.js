function solution(my_string) {
  var answer = 0;
  let operater = 1;

  my_string.split(" ").forEach((char) => {
    if (Number.isInteger(+char)) {
      answer += operater * +char;
    } else {
      operater = char == "-" ? -1 : 1;
    }
  });

  return answer;
}

// val solution = eval 을 사용하면 된다.
