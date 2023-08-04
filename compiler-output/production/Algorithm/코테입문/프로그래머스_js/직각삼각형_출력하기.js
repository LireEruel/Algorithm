const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input = line.split(" ");
}).on("close", function () {
  for (let i = 0; i < Number(input[0]); i++) {
    let stars = "";
    for (let d = 0; d <= i; d++) {
      stars += "*";
    }
    console.log(stars);
  }
});
