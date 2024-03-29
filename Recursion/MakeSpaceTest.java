package Recursion;

import java.util.Scanner;

public class MakeSpaceTest {
    static int white, green;
    static int[][] spaces;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        spaces = new int[N][N];
        for(int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                spaces[r][c] = sc.nextInt();
            }
        }
    }
    private static void makeSpace(int sr, int sc, int size) {
        int sum = 0;
        for(int r = 0; r < sr+size; r++) {
            for (int c = 0; c < sc+size; c++) {
                sum += spaces[r][c];
            }
        }
        if(sum == 0) {
            white++;
        } else if (sum == size * size) {
            green++;
        } else  {
            int half = size/2;
            makeSpace(sr,sc,size);
            makeSpace(sr, sc + half, half);
            makeSpace(sr+ half, sc, half);
            makeSpace(sr + half, sc+half, half);
        }
    }
}
