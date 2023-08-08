package 순열_조합;

import java.util.HashMap;
import java.util.Scanner;

class BOJ220529 {

    static int[][] mbtiList;
    static HashMap<String, Integer> mbtiInfo = new HashMap<String, Integer>();

    static int min = -1;

    static void calc(int cnt, int curt,int selectedCount, int selected[]) {
        if(cnt == mbtiList.length || selectedCount == 3){
            if (selectedCount == 3) {
                int sum = 0;
                for (int i = 0; i < selected.length; i++) {
                    for (int j = i + 1; j < selected.length; j++) {
                        for (int k = 0; k < 4; k++) {
                            sum += Math.abs(mbtiList[i][k] - mbtiList[j][k]);
                        }
                    }
                }
                if (min == -1 || sum < min) {
                    min = sum;
                }
            }
        } else {
            
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        mbtiInfo.put("I", 0);
        mbtiInfo.put("E", 1);
        mbtiInfo.put("N", 0);
        mbtiInfo.put("S", 1);
        mbtiInfo.put("F", 0);
        mbtiInfo.put("T", 1);
        mbtiInfo.put("P", 0);
        mbtiInfo.put("J", 1);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            mbtiList = new int[s.nextInt()][4];
            for (int d = 0; d < mbtiList.length; d++) {
                String mbti[] = s.next().split("");
                for (int j = 0; j < mbti.length; j++) {
                    for (String m : mbti) {
                        mbtiList[d][j] = mbtiInfo.get(m);
                    }
                }
            }
        }
        s.close();
    }
}