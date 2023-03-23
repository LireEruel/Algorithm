function solution(M, N) {
  const max = Math.max(M, N);
  const min = Math.min(M, N);
  return (max - 1) * min + min - 1;
}
