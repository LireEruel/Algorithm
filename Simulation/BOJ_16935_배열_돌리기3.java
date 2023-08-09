package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_16935_배열_돌리기3 {
    public static int N, M, R;
    public static String[][] board;

    public static void 상하_반전() {
        String [][] tempBoard = new String[N][M];
        for (int i = 0; i < board.length; i++) {
            tempBoard[i] = board[N-1-i];
        }
        board = tempBoard;
    }
    private static void 좌우_반전() {
        String [][] tempBoard = new String[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[i][j] = board[i][M - j-1];
            }
        }
        board = tempBoard;

    }
    private static void 우측_전체_회전() {
        String [][] tempBoard = new String[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[j][N-i-1] = board[i][j];
            }
        }
        board = tempBoard;
        N = tempBoard.length;
        M = tempBoard[0].length;
    }

    private static void 좌측_전체_회전() {
        String [][] tempBoard = new String[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[M-j-1][i] = board[i][j];
            }
        }
        board = tempBoard;
        N = tempBoard.length;
        M = tempBoard[0].length;
    }

    private static int 그룹_구하기(int x,int y) {

        if(x < N/2 && y < M/2){
            return 0;
        }
        else if(x < N/2 && y >= M/2){
            return 1;
        }
        else if(x>= N/2 && y < M/2){
            return 2;
        }
        else  { //(x>= N/2 && y >= M/2)
            return 3;
        }
    }


    private static void 우측_그룹_회전() {
        int[] dx = new int[] {0, N/2,-(N/2), 0 };
        int[] dy = new int[] {M/2, 0,  0,-(M/2)};
        String [][] tempBoard = new String[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int 방향 = 그룹_구하기(i, j);
                tempBoard[i + dx[방향]][j + dy[방향]] = board[i][j];
            }
        }
        board = tempBoard;
    }
    private static void 좌측_그룹_회전() {
        int[] dx = new int[] {N/2, 0,0 ,-(N/2)};
        int[] dy = new int[] {0, -(M/2), M/2, 0};
        String [][] tempBoard = new String[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int 방향 = 그룹_구하기(i, j);
                tempBoard[i + dx[방향]][j + dy[방향]] = board[i][j];
            }
        }
        board = tempBoard;
    }

    public static void 연산_매칭하기(int operator){
        switch (operator){
            case 1: {
                상하_반전();
                break;
            }
            case 2 : {
                좌우_반전();
                break;
            }
            case 3 : {
                우측_전체_회전();
                break;
            }
            case 4 : {
                좌측_전체_회전();
                break;
            }
            case 5 : {
                우측_그룹_회전();
                break;
            }
            case 6 : {
                좌측_그룹_회전();
                break;
            }
        }
    }
    public static void 배열_출력하기() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append(String.join(" ", board[i])).append("\n");
        }
        System.out.print(sb);
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        for (int i = 0; i < N; i++) { // 배열에 최초로 담기
            board[i] = br.readLine().split(" ");
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            연산_매칭하기(Integer.parseInt(st.nextToken()));
        }
        배열_출력하기();
    }
}
