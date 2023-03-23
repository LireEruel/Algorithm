function solution(string) {
  string = string.replaceAll("zero", "0");
  string = string.replaceAll("one", "1");
  string = string.replaceAll("two", "2");
  string = string.replaceAll("three", "3");
  string = string.replaceAll("four", "4");
  string = string.replaceAll("five", "5");
  string = string.replaceAll("six", "6");
  string = string.replaceAll("seven", "7");
  string = string.replaceAll("eight", "8");
  string = string.replaceAll("nine", "9");
  return BigInt(string);
}

console.log(solution("onetwothreefourfivesixseveneightnine")); //123456789
