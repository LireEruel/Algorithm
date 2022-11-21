//프로그래머스 > 코딩테스트 연습 > 스택/큐 > 같은 숫자는 싫어

var numIslands = function (grid) {
  const visited = Array.from(Array(grid.length), () =>
    Array(grid[0].length).fill(0)
  );
  let island = 0;
  for (let y = 0; y < grid.length; y++) {
    for (let x = 0; x < grid[0].length; x++) {
      if (grid[y][x] == "1" && visited[y][x] == 0) {
        travel(grid, visited, [x, y]);
        island++;
      }
    }
  }
  return island;
};

const dx = [1, 0, 0, -1];
const dy = [0, 1, -1, 0];

const travel = (grid, visited, location) => {
  const queue = [];
  visited[location[1]][location[0]] = 1;
  queue.push(location);
  while (queue.length > 0) {
    const current_location = queue.pop();
    let x = current_location[0];
    let y = current_location[1];
    // console.log(visited)
    // console.log(current_location)

    for (var i = 0; i < 4; i++) {
      const next_x = x + dx[i];
      const next_y = y + dy[i];

      if (
        next_y > grid.length - 1 ||
        next_x > grid[0].length - 1 ||
        next_x < 0 ||
        next_y < 0
      )
        continue;

      if (!visited[next_y][next_x] && grid[next_y][next_x] === "1") {
        visited[next_y][next_x] = 1;
        queue.push([next_x, next_y]);
      }
    }
  }
};
