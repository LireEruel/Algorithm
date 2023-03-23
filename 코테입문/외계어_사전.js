//https://school.programmers.co.kr/learn/courses/30/lessons/120869

function solution(spells, dic) {
  var answer = 2;
  for (let string of dic) {
    const set = new Set(
      [...string].filter(
        (char) => spells.findIndex((spell) => spell == char) > -1
      )
    );
    if (set.size == spells.length) return 1;
  }

  return answer;
}
