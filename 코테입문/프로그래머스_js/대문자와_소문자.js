//대문자 소문자 변화느ㅡㅡ
function solution(my_string) {
  return my_string
    .split("")
    .map((char) => {
      return char == char.toUpperCase()
        ? char.toLowerCase()
        : char.toUpperCase();
    })
    .join("");
}
