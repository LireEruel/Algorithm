package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class BOJ_탈출 {
    static int R, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() );
        R = Integer.parseInt(st.nextToken());
        C  = Integer.parseInt(st.nextToken());

        int [][] board = new int[R][C];
        ArrayList<String> stringSet = new ArrayList<>();
        stringSet.add(".");
        stringSet.add("*");
        stringSet.add("S");
        stringSet.add("D");
        stringSet.add("X");
        Set<int[]> waters = new HashSet<>();
        int[] dochi = new int[2];
        for (int i = 0; i < R; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                int value = stringSet.indexOf(tokens[j]);
                board[i][j] = value;
                System.out.println(value);
                if(value == 1){
                    waters.add(new int[]{i, j});
                } else if (value == 2) {
                    dochi = new int[]{i , j};
                    board[i][j] = 2;
                }
            }
        }
        int result = dfs(board, waters, dochi, 0);
        if(result == -1){
            System.out.println("KAKTUS");
        }else {
            System.out.println(result);
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1,-1,0,0};
    private static int dfs(int[][] board, Set<int[]> waters,
                           int[] dochi, int count) {
        int result = -1;
        board[dochi[0]][dochi[1]] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + dochi[0];
            int ny = dy[i] + dochi[1];


            if(0 <= nx && nx < R &&0 <= ny && ny < C ){
                int now = board[nx][ny];
                if (now == 1){
                    // 물이 차 있음
                    continue;
                } else if (now == 3) {
                    //target
                    return count;
                } else if (now == 0) {
                    printBoard(board);
                    // 땅
                    Set<int[]> newWaters = watering(board, waters);

                    int res = dfs(board, newWaters, new int[]{nx, ny}, count+1);
                    if(res > 0){
                        if(result <0 || res < result){
                            result = res;
                        }
                    }
                }
            }

        }
        board[dochi[0]][dochi[1]] = 2;
        return result;

    }

    private static void printBoard (int[][] board){
        System.out.println("===================");
        for (int[] row: board
             ) {

            System.out.println(Arrays.toString(row));
        }
    }
    private static Set<int[]> watering(int[][] board, Set<int[]> waters){
        Set<int[]> newWaters = new HashSet<>();
        for (int[] water : waters) {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + water[0];
                int ny = dy[i] + water[1];
                newWaters.add(water);

                if(0 <= nx && nx < R &&0 <= ny && ny < C ){
                    int now = board[nx][ny];
                    if (now == 0) {
                        // 땅
                        newWaters.add(new int[]{nx, ny});
                        board[nx][ny] = 1;
                    }
                }

            }
        }
        return newWaters;
    }
}
