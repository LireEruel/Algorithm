package Simulation;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class BOJ_1181_단어_정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordLength = Integer.parseInt(br.readLine());
        String[] words = new String[wordLength];
        Set<String> wordSet = new HashSet<String>();
        for (int i = 1; i < wordLength; i++) {
            wordSet.add(br.readLine());
        }
        words = wordSet.toArray(new String[0]);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for (String word: words
             ) {
            System.out.println(word);
        }
    }
}
