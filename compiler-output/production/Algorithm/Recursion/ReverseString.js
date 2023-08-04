// leetCode 344.Reverse String
// Easy

var reverseString = function (s) {
  helper(s, 0);
};

const helper = (s, index) => {
  if (index < s.length / 2) {
    helper(s, index + 1);
    const temp = s[s.length - index - 1];
    s[s.length - index - 1] = s[index];
    s[index] = temp;
  }
};
