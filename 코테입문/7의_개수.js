function solution(array) {
  return array
    .join("")
    .split("")
    .filter((char) => char == "7").length;
}

console.log(solution([7, 236, 487, 77]));
