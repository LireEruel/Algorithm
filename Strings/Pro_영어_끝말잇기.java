package Strings;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int person = 1;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if( set.contains(word) || (i > 0 && (words[i-1].charAt(words[i-1].length() - 1) !=word.charAt(0)  )) ){
                answer[0] = person;
                answer[1] = ( i+n-person )/ n;
                break;
            }
            if(person < n) {
                person++;
            }
            else {
                person = 1;
            }
        }

        return answer;
    }
}