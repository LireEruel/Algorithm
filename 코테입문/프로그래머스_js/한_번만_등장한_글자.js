function solution(string) {
  return string
    .split("")
    .filter(
      (char) =>
        [...string]
          .slice([...string].findIndex((c) => c == char) + 1)
          .findIndex((c) => c == char) == -1
    )
    .sort()
    .join("");
}
