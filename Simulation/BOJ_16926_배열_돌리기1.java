package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열_돌리기1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int colLength = Integer.parseInt(st.nextToken());
        int rowLength = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] originalBoard = new int[colLength][rowLength];
        int[][] resultBoard = new int[colLength][rowLength];
        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };
        int defaultDirection, nx, ny = 0;
        int direction = 0;
        int transX = 0;
        int transY = 0;
        for (int i = 0; i < R; i++) {
            nx = transX + dx[direction];
            ny = transY + dy[direction];
            if (nx < 0 || nx >= colLength || ny < 0 || ny >= rowLength) {
                direction = direction == 3 ? 0 : direction + 1;
                nx = transX + dx[direction];
                ny = transY + dy[direction];
            }
            transX = nx;
            transY = ny;
        }

        int[] tempDirection = new int[] { dx[direction], dy[direction] };

        dx = new int[] { 0, 1, 0, -1 };
        dy = new int[] { 1, 0, -1, 0 };

        for (int i = 0; i < 4; i++) {
            if ((dx[i] == tempDirection[0] * -1) && (dy[i] == tempDirection[1] * -1)) {
                direction = i;
            }
        }
        int current;
        int defaultX = 0;
        int defaultY = 0;
        for (int i = 0; i < colLength * rowLength; i++) {
            if (i == 0) {
                resultBoard[transX][transY] = originalBoard[0][0];
                originalBoard[0][0] = 0;
            } else {
                nx = defaultX + dx[direction];
                ny = defaultY + dy[direction];
                if (nx < 0 || nx == colLength || ny < 0 || ny == rowLength || originalBoard[nx][ny] != 0) {
                    direction = direction == 3 ? 0 : direction + 1;
                    nx = defaultX + dx[direction];
                    ny = defaultY + dy[direction];
                }
                current = originalBoard[nx][ny];
                originalBoard[nx][ny] = 0;
            }
        }

    }
}
