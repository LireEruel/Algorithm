function solution(my_string, num1, num2) {
  my_string = my_string.split("");
  const memo = my_string[num1];

  my_string[num1] = my_string[num2];
  my_string[num2] = memo;

  return my_string.join("");
}
