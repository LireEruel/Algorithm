package Recursion;

import java.io.*;
import java.util.*;

public class BOJ1074_Z {
    static int[][] board;
    static int N;
    static int R;
    static int C;
    static int cnt;
    static int result = -1;
    static void req(int r1,int r2, int c1, int c2) {
        if(r2 - r1 ==1) {
            int [] nr = new int[] {r1,r1,r2,r2};
            int [] nc = new int[]{c1,c2,c1,c2};
            for (int i = 0; i < 4; i++) {
                if(nr[i] ==R && nc[i] == C ){
                    result = cnt;
                    break;
                }
            }

        }
        else {
            if(R <= r1 + (r2-r1)/2){
                if(C <= c1 + (c2-c1)/2 ){
                    req(r1,r1 + (r2-r1)/2,c1,c1 + (c2-c1)/2);
                }
                else {
                    req(r1,r1 + (r2-r1)/2,c1 + (c2-c1)/2,c2);
                }
            }
            else {
                if(C <= c1 + (c2-c1)/2 ){
                    req(r1 + (r2-r1)/2+1, r2, c1,c1 + (c2-c1)/2);
                }
                else {
                    req(r1 + (r2-r1)/2+1,r2,c1 + (c2-c1)/2+1,c2);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        req(0,N-1,0,N-1);
        System.out.println(result);
    }
}
