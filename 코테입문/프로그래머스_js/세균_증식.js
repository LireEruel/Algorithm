function solution(n, t) {
  let current = 0;
  while (current < t) {
    current++;
    n *= 2;
  }

  return n;
}
