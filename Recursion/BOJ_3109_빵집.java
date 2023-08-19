package Recursion;
import java.io.*;
import java.util.*;
public class BOJ_3109_빵집 {
    static int[][] board;
    static int R;
    static int C;
    static int result = 0;
    static int[] dx = new int[]{-1,0,1};
    static int[] dy = new int[]{1,1,1};
    static boolean dfs (int x, int y) {
        if(y == C -1) {
            result++;
            return true;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            board[x][y] = 1;
            if(nx >=0 && nx < R && ny >=0 && ny <C && board[nx][ny] == 0 ){
                boolean result = dfs(nx,ny);
                if(result){
                    return true;
                }
                board[x][y] = 0;

            }
        }
        return  false;
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R  = Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if(str[j].equals("x")) {
                    board[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            dfs(i,0);
        }

        System.out.println(result);
    }
}
