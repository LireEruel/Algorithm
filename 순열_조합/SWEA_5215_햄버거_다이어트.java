package 순열_조합;

import java.io.*;
import java.util.*;

public class SWEA_5215_햄버거_다이어트 {
    static int N, L;
    static  int max = 0;
    static int [][] ingredents;
    public static void calc(int cnt, int scoreSum, int calSum) {
        if(cnt == N) {
            if(scoreSum > max) {
                max = scoreSum;
            }
        }else {
            calc(cnt+1, scoreSum, calSum);
            scoreSum += ingredents[cnt][0];
            calSum += ingredents[cnt][1];
            if(calSum <= L){
                calc(cnt+1, scoreSum, calSum);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase= 1 ; testCase < T+1; testCase++) {
            sb.append("#").append(testCase).append(" ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredents = new int[N][2];
            max = 0;
            for (int i = 0; i < N; i++) { // 재료들 배열에 다 넣기
                st = new StringTokenizer(br.readLine());
                ingredents[i][0] = Integer.parseInt(st.nextToken());
                ingredents[i][1] = Integer.parseInt(st.nextToken());
            }
            calc(0, 0, 0);
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
