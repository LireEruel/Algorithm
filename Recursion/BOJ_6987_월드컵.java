package Recursion;

import java.io.*;
import java.util.*;

public class BOJ_6987_월드컵 {

    static int [][] result = new int[6][3];
    static int[][] playSets = new int[30][2];
    static int[][] current = new int[6][3];
    static int[] win = new int[6];
    static int[] loss = new int[6];
    static int[] draw = new int[6];
    static boolean success = false;
    static void dfs(int idx) {
        if(success) return;
        if(idx == 15) {
            success = true;
            return;
        }
        int a = playSets[idx][0]; //a 팀
        int b = playSets[idx][1]; // b팀

        //a 가 b 에게 이기는 경우
        if( win[a] > 0 && loss[b] >0 ) {
            win[a]--;
            loss[b]--;
            dfs(idx+1);
            win[a]++;
            loss[b]++;
        }
        //a 가 b 에게 지는 경우
        if( loss[a] > 0 && win[b] >0 ) {
            loss[a]--;
            win[b]--;
            dfs(idx+1);
            loss[a]++;
            win[b]++;
        }
        // a와 b가 비기는 경우
        if( draw[a] > 0 && draw[b] >0 ) {
            draw[a]--;
            draw[b]--;
            dfs(idx+1);
            draw[a]++;
            draw[b]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                playSets[index] = new int[]{i,j};
                index++;
            }
        }

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            success = true;
            for (int j = 0; j < 6; j++) {
                win[j] = Integer.parseInt(st.nextToken());
                draw[j] = Integer.parseInt(st.nextToken());
                loss[j] = Integer.parseInt(st.nextToken());
                if(win[j] + draw[j] + loss[j] != 5) {
                    success = false;
                    break;
                }
            }
            if(!success) {
                sb.append("0 ");
            }
            else {
                success = false;
                dfs(0);
                sb.append(success == true ? "1 ": "0 ");
            }
        }
        System.out.println(sb);
    }
}
