//https://school.programmers.co.kr/learn/courses/30/lessons/120883

function solution(id_pw, db) {
  var answer = "";
  const targetData = db.find((data) => data[0] == id_pw[0]);
  if (!targetData) {
    return "fail";
  } else if (targetData[1] == id_pw[1]) return "login";
  else {
    return "wrong pw";
  }
}
