function solution(genres, plays) {
  var answer = [];
  var arr = [];
  let obj = {
    genre: genres[0],
    list: [plays[0]],
    indexs: [0],
    sum: plays[0],
  };
  arr.push(obj); // 첫번째는 미리 넣어둠
  //장르별로 정리함
  for (let i = 1; i < plays.length; i++) {
    const index = arr.findIndex((item) => item.genre == genres[i]);
    if (index > -1) {
      arr[index].list.push(plays[i]);
      arr[index].sum += plays[i];
      arr[index].indexs.push(i);
    } else {
      arr.push({
        genre: genres[i],
        list: [plays[i]],
        indexs: [i],
        sum: plays[i],
      });
    }
  }

  arr.sort((a, b) => b.sum - a.sum);
  //합산 재생수가 높은 순으로 arr 정렬
  for (let i = 0; i < arr.length; i++) {
    const target = arr[i];
    let maxIndex = target.list.findIndex(
      (item) => item == Math.max(...target.list)
    );
    answer.push(target.indexs[maxIndex]);
    target.list.splice(maxIndex, 1);
    target.indexs.splice(maxIndex, 1);
    if (target.list.length > 0) {
      maxIndex = target.list.findIndex(
        (item) => item == Math.max(...target.list)
      );
      answer.push(target.indexs[maxIndex]);
    }
  }

  return answer;
}
