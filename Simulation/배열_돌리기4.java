package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열_돌리기4 {
    public static int N, M, K;
    //public static int[][] board;

    private static void rotate(int[][] board, int r, int c, int s) {
        int startX = r - s -1;
        int startY = c -s -1;
        int endX = r + s - 1;
        int endY = c + s- 1;
        int [] dx = new int[] {0,1,0,-1};
        int [] dy = new int[] {1,0,-1,0};
        int nx, ny;
        int direction = 0;
        int x = startX;
        int y = startY;
        int before = board[x][y];
        // 양파처럼 한꺼풀씩 벗겨볼까?
        while(startX < endX) {
            nx = x + dx[direction];
            ny = y + dy[direction];
            if(nx < startX || nx > endX || ny < startY || ny > endY) {
                if(direction == 3) {
                    startX++;
                    startY++;
                    endX--;
                    endY--;
                    nx = startX;
                    ny = startY;
                    direction = 0;
                    if(startX == endX){
                        break;
                    }
                }else {
                    direction ++;
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }

            }
            x = nx;
            y = ny;
            int temp = board[x][y];
            board[x][y] = before;
            before = temp;
        }
    }

    public static void printArr(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            sb.append(Arrays.toString(ints)).append("\n");
        }
        System.out.print(sb);
    }

    public static int[] selected;
    public static ArrayList<int[]> instructionsSet = new ArrayList<int[]>();

    public static void getPermutation(int cnt, int[] list) { // 순열 구하기
        if(cnt == K){
            instructionsSet.add(list.clone());
        }
        else {
            for (int i = 0; i < K; i++) {
                if(selected[i] == 0){
                    list[cnt] = i;
                    selected[i] = 1;
                    getPermutation(cnt +1, list);
                    selected[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) { // 배열에 최초로 담기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] instructions = new int[K][3];
        selected = new int[K];
        getPermutation(0, new int[K]);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                instructions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        for (int[] order :instructionsSet) {
            int[][] temp = new int[N][M];
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <M; j++) {
                    temp[i][j] = board[i][j];
                }
            }
            for (int current : order) {
                int[] instruction = instructions[current];
               rotate(temp, instruction[0], instruction[1], instruction[2]);
            }
            //printArr(temp);
            for (int i = 0; i < temp.length; i++) {
                int sum = 0;
                for (int j = 0; j < temp[0].length; j++) {
                    sum += temp[i][j];
                }
                if(result == -1 || sum < result) {
                    result = sum;
                }
            }
        }
        System.out.println(result);
    }
}
