//프로그래머스 > 코딩테스트 연습 > 스택/큐 > 같은 숫자는 싫어

function solution(arr) {
  return arr.filter((elem, index) => elem != arr[index + 1]);
}
