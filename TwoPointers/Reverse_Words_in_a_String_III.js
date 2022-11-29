// leetCode 557. Reverse Words in a String III
// Easy

var reverseWords = function (s) {
  let words = s.split(" ");
  for (let i = 0; i < words.length; i++) {
    let targetWord = words[i].split("");
    for (let d = 0; d < targetWord.length / 2; d++) {
      let temp = targetWord[d];
      //swap
      targetWord[d] = targetWord[targetWord.length - 1 - d];
      targetWord[targetWord.length - 1 - d] = temp;
    }
    words[i] = targetWord.join("");
  }
  return words.join(" ");
};
