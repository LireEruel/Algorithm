function solution(score) {
  const sorted = [...score].sort((a, b) => getEverage(b) - getEverage(a));
  const result = [];
  const indexList = sorted.map((data) =>
    score.findIndex((s) => s[0] == data[0] && s[1] == data[1])
  );
  const orders = [];
  sorted.forEach((s, index) => {
    if (index > 0 && getEverage(s) == getEverage(sorted[index - 1])) {
      orders[index] = orders[index - 1];
    } else {
      orders[index] = index + 1;
    }
  });
  orders.forEach((order, index) => {
    result[indexList[index]] = order;
  });
  return result;
}

function getEverage(list) {
  return list.reduce((sum, current) => (sum += current)) / list.length;
}

console.log(
  solution([
    [80, 70],
    [70, 80],
    [30, 50],
    [90, 100],
    [100, 90],
    [100, 100],
    [10, 30],
  ]) //[4,4,6,2,2,1,7]
);

// 더 좋은 풀이

// 이런 순위 매기기 방식은 자기보다 점수가 높은 사람의 수  + 1 로 이해하면 된다.
// 연산량은 좀 많음.

function solution(score) {
  return score.map((el) => {
    return (
      score.filter((v) => (v[0] + v[1]) / 2 > (el[0] + el[1]) / 2).length + 1
    );
  });
}
