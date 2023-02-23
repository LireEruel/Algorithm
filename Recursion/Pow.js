// leetCode Pow(x, n)
// https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/

var myPow = function (x, n) {
  let memo = [1];

  const myRecul = (x, n) => {
    let res;
    // console.log(x,n)
    if (n == 0) return 1;
    if (n > 0) {
      if (memo[n] !== undefined) {
        return memo[n];
      }
      if (n == 1) {
        res = x;
      } else if (n % 2 == 1) {
        res = x * myRecul(x, (n - 1) / 2) * myRecul(x, (n - 1) / 2);
      } else {
        res = myRecul(x, n / 2) * myRecul(x, n / 2);
      }
      memo[n] = res;
    } else {
      console.log(x, n);
      if (memo[n * -1] !== undefined) {
        return memo[n * -1];
      }
      if (n == -1) {
        res = 1 / x;
      } else if ((n * -1) % 2 == 1) {
        res = x * myRecul(x, (n - 1) / 2) * myRecul(x, (n - 1) / 2);
      } else {
        res = myRecul(x, n / 2) * myRecul(x, n / 2);
      }
      memo[n * -1] = res;
    }
    return res;
  };
  //console.log(memo)
  return myRecul(x, n);
};
