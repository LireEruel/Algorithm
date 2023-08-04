//프로그래머스 > 코딩테스트 연습 > 스택/큐 > 다리를 지나는 트럭

function solution(bridge_length, weight, truck_weights) {
  const bridge = [];
  let total_weights = 0;
  let timer = 1;
  while (truck_weights.length + bridge.length > 0) {
    timer++;
    if (total_weights + truck_weights[0] <= weight) {
      bridge.push([0, truck_weights[0]]);
      total_weights += truck_weights[0];
      truck_weights.splice(0, 1);
    }
    bridge.map((truck) => {
      truck[0] += 1;
    });
    if (bridge[0][0] == bridge_length) {
      total_weights -= bridge[0][1];
      bridge.splice(0, 1);
    }
    // console.log("bridge : ", bridge)
    // console.log("timer : ", timer)
  }

  return timer;
}
