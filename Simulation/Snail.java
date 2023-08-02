package Simulation;

import java.io.*;
import java.util.Arrays;

public class Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = new int[]{0, 1, 0 , -1};
        int[] dy = new int[]{1,0, -1, 0};
        int direction = 0;
        for (int test_case = 1; test_case < T+1; test_case++) {
            System.out.printf("#%d\n", test_case);
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            int current = 1;
            int x = 0;
            int y = -1;
            int nx, ny;
            direction = 0;
            while(current <= N*N)
            {
                nx = x + dx[direction];
                ny = y + dy[direction];
                if( nx < 0 || nx == N|| ny < 0 || ny == N || board[nx][ny] != 0) {
                    direction = direction == 3 ? 0 : direction+1;
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                board[nx][ny] = current;
                x = nx;
                y = ny;
                current++;
            }
            for (int[] row: board) {
                //System.out.println(Arrays.toString(row));
                System.out.println(Arrays.toString(row).replaceAll("[^0-9 ]", ""));
            }
        }
    }
}
