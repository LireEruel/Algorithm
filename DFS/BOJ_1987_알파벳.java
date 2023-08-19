package DFS;

import java.io.*;
import java.util.*;

public class BOJ_1987_알파벳 {
    static int R,C;
    static String[][] board;
    static Set<String> set = new HashSet<>();

    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static int dfs(int x, int y, int cnt){
        int nx, ny;
        int max = cnt;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(0<=nx && nx<R && 0<=ny && ny<C && !set.contains(board[nx][ny])){
                set.add(board[nx][ny]);
                int temp = dfs(nx,ny,cnt+1);
                if(max < temp) {
                    max = temp;
                }
                set.remove(board[nx][ny]);
            }
        }
        cnt = max;
        return cnt;
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
        }
        set.add(board[0][0]);
        System.out.println(dfs(0,0,1));
    }
}
