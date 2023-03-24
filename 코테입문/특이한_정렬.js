function solution(numlist, n) {
  return numlist.sort((a, b) => {
    const distenceA = (n - a) * (n - a);
    const distenceB = (n - b) * (n - b);
    if (distenceA == distenceB) {
      return b - a;
    } else {
      return distenceA - distenceB;
    }
  });
}
