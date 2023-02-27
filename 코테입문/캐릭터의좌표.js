//프로그래머스 캐릭터의 좌표
function solution(keyinput, board) {
  var answer = [0, 0];
  const xRange = [(-1 * (board[0] - 1)) / 2, (board[0] - 1) / 2];
  const yRange = [(-1 * (board[1] - 1)) / 2, (board[1] - 1) / 2];

  for (let key of keyinput) {
    switch (key) {
      case "up": {
        if (answer[1] < yRange[1]) answer[1] += 1;
        break;
      }
      case "down": {
        if (answer[1] > yRange[0]) answer[1] -= 1;
        break;
      }
      case "left": {
        if (answer[0] > xRange[0]) answer[0] -= 1;
        break;
      }
      case "right": {
        if (answer[0] < xRange[1]) answer[0] += 1;
        break;
      }
    }
  }
  return answer;
}
