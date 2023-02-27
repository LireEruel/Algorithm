//leetcode 
//https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/

// 이런 반복되는 문제는 트리를 그려서 규칙을 찾으려고 해보자!

var kthGrammar = function(n, k) {
    if(n == 1 || k == 1) return 0;
    if(k%2)
      {
        return kthGrammar(n-1, (k+1)/2 ) == 1 ? 1 : 0    
      }
    else
      {
        return !kthGrammar(n-1, k/2)
      }
  };