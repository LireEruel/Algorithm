package 순열_조합;

import java.io.*;
import java.util.*;


public class BOJ_1759_암호_만들기 {
    static Set<Integer> vowelSet = new HashSet();
    static String[] sList ;
    static int L, C;
    static StringBuilder result = new StringBuilder();
    static void makePassword (int cnt, String current, int vowelCount) {
        if(current.length() == L || cnt == C){
            if(current.length() == L&& vowelCount >= 1 && L-vowelCount >=2){
                result.append(current).append("\n");
            }
        }
        else {
            String curt = sList[cnt];
            makePassword(cnt+1, current + curt, vowelSet.contains(cnt) ? vowelCount+1 : vowelCount );
            makePassword(cnt+1, current, vowelCount);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sList = br.readLine().split(" ");
        Arrays.sort(sList);
        for (int i = 0; i < C; i++) {
            switch (sList[i]) {
                case "a", "e", "i", "o", "u" -> vowelSet.add(i);
            }
        }

        makePassword(0, "", 0);
        System.out.println(result);
    }
}
