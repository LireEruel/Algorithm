package Simulation;

import java.io.*;
import java.util.*;
public class SWEA_1873_상호의_배틀필드 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String [][] board;
        StringTokenizer st;
        int R, C;
        for (int testCase = 1; testCase < T+1; testCase++) {
            sb.append('#').append(testCase).append(' ');
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new String[R][C];
            int x= 0;
            int y = 0;
            int direction = 0;
            for (int i = 0; i < R; i++) {
                String[] row = br.readLine().split("");
                board[i] = row;
                for (int d = 0; d < C; d++) {

                    if( row[d].equals("<") || row[d].equals(">") || row[d].equals("^") || row[d].equals("v")){
                        x = i;
                        y = d;
                        switch (row[d]) {
                            case "^" : {
                                direction =0;
                                break;
                            }
                            case "v" : {
                                direction = 1;
                                break;
                            }
                            case "<" : {
                                direction = 2;
                                break;
                            }
                            case ">" : {
                                direction = 3;
                                break;
                            }
                            default : {
                                x = i;
                                y = d;
                            }
                        }
                    }
                }
            }
            int inputLenth = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split("");

            int []dx = new int []{-1,1,0,0};
            int []dy = new int []{0,0,-1,1};
            for (int i = 0; i < inputLenth; i++) {

                String input = inputs[i];
//                System.out.println("================input "+ input+ "=========");

                switch (input) {
                    case "U" :{
                        board[x][y] = "^";
                        direction = 0;
                        if(x > 0 && board[x-1][y].equals(".") ){
                            board[x][y] = ".";
                            board[x-1][y] = "^";
                            x--;
                        }
                        break;
                    }
                    case "D" : {
                        board[x][y] = "v";
                        direction = 1;
                        if(x < R-1 && board[x+1][y].equals(".") ){
                            board[x][y] = ".";
                            board[x+1][y] = "v";
                            x++;
                        }
                        break;
                    }
                    case "L" : {
                        board[x][y] = "<";
                        direction = 2;
                        if(y > 0 && board[x][y-1].equals(".") ){
                            board[x][y] = ".";
                            board[x][y-1] = "<";
                            y--;
                        }
                        break;
                    }
                    case "R" : {
                        board[x][y] = ">";
                        direction = 3;
                        if(y < C-1 && board[x][y+1].equals(".")){
                            board[x][y] = ".";
                            board[x][y+1] = ">";
                            y++;
                        }
                        break;
                    }
                    case "S" : {
                        int nx = x + dx[direction];
                        int ny = y + dy[direction];
                        String current = "";
                        while(0 <= nx && nx <R && 0 <= ny && ny <C ) {
                            current = board[nx][ny];
                            if(current.equals("*") || current.equals("#")) {
                                if(current.equals("*")) {
                                    board[nx][ny] = ".";
                                }
                                break;
                            }
                            nx += dx[direction];
                            ny += dy[direction];
                        }
                        break;
                    }
                }
//                for (int d = 0; d < R; d++) {
//                    for (int k = 0; k < C; k++) {
//                        System.out.print(board[d][k]);
//                    }
//                    System.out.println();
//                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
