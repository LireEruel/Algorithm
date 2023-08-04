//프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 체육복

function solution(n, lost, reserve) {
  let index;
  lost = lost.sort((a, b) => a - b);
  reseve = reserve.sort((a, b) => a - b);
  const lo = JSON.parse(JSON.stringify(lost));
  const re = JSON.parse(JSON.stringify(reserve));
  for (let i = 0; i < reserve.length; i++) {
    server = reserve[i];
    index = lo.findIndex((elem) => elem == server);
    if (index > -1) {
      console.log(lo[index]);
      lo.splice(index, 1);
      index = re.findIndex((elem) => elem == server);
      re.splice(index, 1);
    }
  }
  console.log(lo, re);
  lost = lo;
  reserve = re;
  for (let i = 0; i < reserve.length; i++) {
    server = reserve[i];
    if (server > 1) {
      index = lost.findIndex((elem) => elem == server - 1);
      if (index > -1) {
        lost.splice(index, 1);
        continue;
      }
    }

    if (server < n) {
      index = lost.findIndex((elem) => elem == server + 1);
      if (index > -1) {
        lost.splice(index, 1);
        continue;
      }
    }
  }

  return n - lost.length;
}
