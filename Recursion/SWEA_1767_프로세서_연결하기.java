package Recursion;

import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서_연결하기 {

    static int [] result = new int[]{0,0};
    static int[][] board;
    static int N;

    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};

    static class Core{
        int x, y;
        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Core> coreList = new ArrayList<>();

    static int draw(int x, int y, int direction, int cnt){
           int res = cnt;
           int nx = x + dx[direction];
           int ny = y + dy[direction];
           if(nx < 0 || ny < 0 || nx == N || ny == N){
               return cnt;
           }else if(board[nx][ny] == 1) {
               return -1;
           }else {
               board[nx][ny] = 1;
               res = draw(nx,ny,direction, cnt+1);
               if(res == -1){
                   board[nx][ny] = 0;
               }
           }
           return  res;
    }

    static void remove(int x, int y, int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if(nx > -1 && nx < N && ny > -1 && ny < N){
            board[nx][ny] = 0;
            remove(nx,ny,direction);
        }
    }

    static void printBoard() {

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("=================================================");
    }
    static void viewBoard(int connectCount, int length, int coreIndex) {
        //현재 코어 연결 방향 4개 테스트하기.
        //지금이 마지막 코어라면 result 업데이트하기.
        // 마지막 아니라면 다음 코어 돌리기.
       //System.out.println("connectCount : "+ connectCount + " length:  "+  length + " coreIndex : " + coreIndex);

        if(coreIndex == coreList.size()){
            if(result[0] < connectCount || (result[0] == connectCount && result[1] > length)){
                result[0] = connectCount;
                result[1] = length;
              //System.out.println("res 업데이트");
            }
            return;
        }


        Core core = coreList.get(coreIndex);


        for (int direction = 0; direction < 4; direction++) {
            // 계속 깊은복사로 새거 주는게 편하겠지만....
            // 갔다가 아니면 되돌아오는 코드가 필요하다. 어차피!

            int len = draw(core.x, core.y, direction, 0);
            //System.out.println("connectCount : "+ connectCount + " length:  "+  length + " coreIndex : " + coreIndex + "   "+"x : " + core.x + " y : " + core.y + " plus pipe len : " + len);
            //printBoard();
            if(len > 0){
                viewBoard(connectCount+1, length+len, coreIndex+1);
                remove(core.x, core.y, direction);
            }else {
                viewBoard(connectCount, length, coreIndex+1);
            }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <T+1 ; testCase++) {
            N =Integer.parseInt(br.readLine());
            board = new int[N][N];
            result = new int[]{0,0};
            coreList.clear();
            for (int x = 0; x < N; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int y = 0; y < N; y++) {
                    int current = Integer.parseInt(st.nextToken());
                    board[x][y] = current;
                    if(current == 1 && x!=0 && x!=N-1 &&y!=0 && y!=N-1){
                        coreList.add(new Core(x,y));
                    }
                }
            }
            viewBoard(0,0,0);
            sb.append("#").append(testCase).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }
}
