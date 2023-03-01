function solution(array) {
  var answer = 0;
  const record = [];
  record.length = 1001;
  record.fill(0);

  for (let num of array) {
    record[num]++;
  }

  const max = Math.max(...record);

  return record.filter((a) => a == max).length > 1
    ? -1
    : record.findIndex((num) => num == max);
}
