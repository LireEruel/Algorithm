function solution(my_string) {
  return my_string
    .split("")
    .filter((char) => !isNaN(char))
    .map((char) => parseInt(char))
    .sort((a, b) => a - b);
}
