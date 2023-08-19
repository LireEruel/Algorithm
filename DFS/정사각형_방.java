package DFS;

import java.util.*;
import java.io.*;

public class 정사각형_방 {
    
    
    public static int max;
    public static int N;
    public static int[][] rooms;

    static int[] dx = new int[] { 1, 0, -1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static int dfs(int[][] roomList, int x, int y, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) 
            {
                if (roomList[x][y] + 1 == roomList[nx][ny]) {
                    int result = dfs(roomList, nx, ny, cnt + 1);
                    if (result > cnt ) {
                        cnt = result;
                    }
                }
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase < T + 1; testCase++) {
            sb.append("#").append(testCase).append(" ");
            N = Integer.parseInt(br.readLine());
            rooms = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int room = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int result = dfs(rooms, i, j, 1);
                    if (max <= result) {
                        if (room == 0 || rooms[i][j] < room || max < result) {
                            room = rooms[i][j];
                        }
                         max = result;
                    }
                }
            }
            sb.append(room).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
