package BFS;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10971_외판원_순회 {

    static int N, w[][];

    static int min = -1;
    static int start;
    static void dfs(int current, int cnt, int[] selected, int cost){
        if( cnt == N-1 ){
            if(w[current][start] != 0){
                cost += w[current][start];
                if(min == -1 || cost < min){
                    min = cost;
                }
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                if(w[current][i] != 0 && (min == -1 || cost + w[current][i] < min) && selected[i] != 1){
                    selected[i] = 1;
                    dfs(i, cnt+1, selected, cost + w[current][i]);
                    selected[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int[] selected = new int[N];
            selected[i] = 1;
            start = i;
            dfs(i, 0, selected, 0);
        }
        System.out.println(min);
    }
}
