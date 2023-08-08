package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_16926_배열_돌리기1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        ArrayList<Queue<Integer>> queueList = new ArrayList<Queue<Integer>>();
        
        int[][] originalBoard = new int[N][M];
        int[][] resultBoard = new int[N][M];
        int[] dx = new int[]{0, 1, 0 , -1};
        int[] dy = new int[]{1,0, -1, 0};

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                originalBoard[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int nx, ny;
        int direction = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int x = 0;
        int y = -1;
    
        for (int i = 0; i < N *M ; i++) {
            nx = x + dx[direction];
            ny = y + dy[direction];
            if (nx < 0 || nx == N || ny < 0 || ny == M || originalBoard[nx][ny] == 0) {
                if(direction == 3) {
                    queueList.add(queue);
                    queue = new LinkedList<Integer>();
                }
                direction = direction == 3 ? 0 : direction + 1;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
            queue.add(originalBoard[nx][ny]);
            originalBoard[nx][ny] = 0;
        }
        queueList.add(queue);
            
        int count = 0;

        for (Queue<Integer> q : queueList) {
            direction = 0;
            for (int i = 0; i < R; i++) {
                q.add(q.poll());
            }
            x = count;
            y = count-1;
            int length = q.size();
            for (int i = 0; i < length; i++) {
                nx = x + dx[direction];
                ny = y + dy[direction];
                if (nx < 0 || nx == N || ny < 0 || ny == M || resultBoard[nx][ny] != 0) {
                    direction = direction == 3 ? 0 : direction + 1;
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                x = nx;
                y = ny;
                resultBoard[x][y] = q.poll();
            }
            count++;
        }
        for (int[] row: resultBoard) {
            System.out.println(Arrays.toString(row).replaceAll("[^0-9 ]", ""));
        }
    }
}
