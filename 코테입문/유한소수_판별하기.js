function solution(a, b) {
  let index = 2;

  while (index <= a && index <= b) {
    if (a % index == 0 && b % index == 0) {
      a /= index;
      b /= index;
      index = 1;
    }
    index++;
  }
  console.log(a, b);

  while (b % 2 == 0) {
    b = b / 2;
  }
  while (b % 5 == 0) {
    b = b / 5;
  }
  if (b == 1) {
    return 1;
  } else {
    return 2;
  }
}

console.log(solution(11, 22)); //1
