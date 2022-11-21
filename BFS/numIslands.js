// leetCode > 200.Number of Islands

var numIslands = function (grid) {
  const visited = [];
  visited.length = grid.length();
  for (let i = 0; i < grid.length; i++) {
    for (let d = 0; d < grid[0].length; d++) {
      visited[i][d] = "0";
    }
  }
  console.log(visited);
};

const input = [
  ["1", "1", "1", "1", "0"],
  ["1", "1", "0", "1", "0"],
  ["1", "1", "0", "0", "0"],
  ["0", "0", "0", "0", "0"],
];

numIslands(input);
