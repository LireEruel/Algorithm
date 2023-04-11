function solution(cipher, code) {
  return cipher
    .split("")
    .map((a, index) => ((index + 1) % code == 0 ? a : ""))
    .join("");
}
