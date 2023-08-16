package Recursion;

import java.io.*;
import java.util.*;

public class BOJ1992_쿼드트리 {


    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    static boolean canZip(int startX, int startY, int N) {
        int first = board[startX][startY];
        for (int x = startX; x < startX+N; x++) {
            for (int y = startY; y < startY+N; y++) {
                if(first != board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void compression(int startX, int startY, int N){
        boolean canZip = true;
        int first = board[startX][startY];
        if(canZip(startX,startY,N)){
            sb.append(first);
        }else {
            sb.append("(");
            compression(startX, startY, N/2);
            compression(startX, startY+ N/2, N/2);
            compression(startX+N/2, startY,N/2);
            compression(startX+N/2,startY+ N/2, N/2);
            sb.append((")"));
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int first = 0;
        boolean canZip = true;
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                int token = Integer.parseInt(row[j]);
                board[i][j] = token;
                if(i == 0 && j == 0){
                    first = token;
                }else {
                    if(token != first) {
                        canZip = false;
                    }
                }
            }
        }
        if(canZip == true) {
            System.out.println(first);
        }
        else {
            compression(0,0,N);
            System.out.println(sb);
        }
    }
}
