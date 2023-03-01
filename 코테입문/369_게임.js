function solution(order) {
  return order
    .toString()
    .split("")
    .filter((char) => char == "3" || char == "6" || char == "9").length;
}
