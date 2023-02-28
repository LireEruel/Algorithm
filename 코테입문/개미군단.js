function solution(hp) {
  var answer = 0;
  if (hp >= 5) {
    answer = Math.floor(hp / 5);
    hp = hp % 5;
  }
  if (hp >= 3) {
    answer += Math.floor(hp / 3);
    hp = hp % 3;
  }
  return (answer += hp);
}
