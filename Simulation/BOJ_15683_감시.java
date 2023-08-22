package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_15683_감시 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int[] dx = new int [] {0,0,1,-1};
        int[] dy = new int [] {1,-1,0,0};
        // 0 : 우, 1 : 좌, 2: 아래, 3: 밑
        ArrayList<ArrayList<Integer>> cctvList =  new ArrayList<>();
        // rotate 하지 않은 상태로 배열 만들고 min값 초기화 한 후 하나씩 돌려보면서 확인.?
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
