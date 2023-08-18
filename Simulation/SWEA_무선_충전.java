package Simulation;

import java.io.*;
import java.util.*;

public class SWEA_무선_충전 {
    static int[] dy = new int[] {0,-1,0,1,0};
    static int[] dx = new int[] {0,0,1,0,-1};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase < T+1; testCase++) {
            stringBuilder.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int bcCount = Integer.parseInt(st.nextToken());
            String[] sa = br.readLine().split(" ");
            String[] sb = br.readLine().split(" ");
            int [] a_move = new int[t];
            int [] b_move = new int[t];

            for (int i = 0; i < t; i++) {
                a_move[i] = Integer.parseInt(sa[i]);
                b_move[i] = Integer.parseInt(sb[i]);
            }

            int[][] bcList = new int[bcCount][4];
            // 같은 BC인 경우 다른 BC 접속 가능하면 각각 다른데로 옮길 수 있는지 확인하고 가능하면 옮긴다.
            for (int i = 0; i < bcCount; i++ ){
                st = new StringTokenizer(br.readLine());
                bcList[i][0] = Integer.parseInt(st.nextToken()); //x
                bcList[i][1] = Integer.parseInt(st.nextToken());// y
                bcList[i][2] = Integer.parseInt(st.nextToken());// 범위
                bcList[i][3] = Integer.parseInt(st.nextToken());// 성능
            }
            int[] a = new int[]{1,1};
            int[] b = new int[]{10,10};
            int sum = 0;
            for (int step = 0; step <= t; step++) {
                int a_bc = -1;
                int b_bc = -1;
                ArrayList<Integer> a_list = new ArrayList<>();
                ArrayList<Integer> b_list = new ArrayList<>();

                for (int j = 0; j < bcCount; j++) {
                    int x = bcList[j][0];
                    int y = bcList[j][1];
                    double a_distance = Math.abs(a[0] - x) + Math.abs(a[1] - y);
                    double b_distance = Math.abs(b[0] - x) + Math.abs(b[1] - y);
                    if(a_distance <= bcList[j][2]){
                        a_list.add(j);
                        if(a_bc == -1 || bcList[a_bc][3] < bcList[j][3]){
                            a_bc = j;
                        }
                    }
                    if(b_distance <= bcList[j][2]){
                        b_list.add(j);
                        if(b_bc == -1 || bcList[b_bc][3] < bcList[j][3]){
                            b_bc = j;
                        }
                    }
                }
                if((a_bc != b_bc) || (a_bc == -1 && b_bc == -1)) { // 변경 없이 바로 적용 하는 경우
                    if(a_bc > -1){
                        sum += bcList[a_bc][3];
                    }
                    if(b_bc > -1){
                        sum += bcList[b_bc][3];
                    }
                }
                else{// a_bc나 b_bc가 -1인 경우는 없다.
                    int temp = bcList[a_bc][3]; //현재 충전량
                    int max = temp; // 둘다 변경 불가할 수 있으므로 temp가 초기값
                    // a만 바꾸는 경우
                    if(a_list.size()>1){
                        int aMax = 0;
                        for (int a_bcIndex : a_list) {
                            if(a_bcIndex != a_bc && bcList[a_bcIndex][3] > aMax ){
                                aMax = bcList[a_bcIndex][3];
                            }
                        }
                        if(max< temp + aMax){
                            max = temp + aMax;
                        }
                    }
                    // b만 바꾸는 경우
                    if(b_list.size()>1){
                        int bMax = 0;
                        for (int b_bcIndex : b_list) {
                            if(b_bcIndex != b_bc && bcList[b_bcIndex][3] > bMax ){
                                bMax = bcList[b_bcIndex][3];
                            }
                        }
                        if(max< temp + bMax){
                            max = temp + bMax;
                        }
                    }
                    // 둘다 제일 큰거 했기 때문에 둘 다 바꾸는 경우는 하지 않는다.
                    sum += max;
                }

                if(step == t) {
                    stringBuilder.append(sum).append("\n");
                }
                else {
                    a[0] = a[0] + dx[a_move[step]];
                    a[1] = a[1] + dy[a_move[step]];
                    b[0] = b[0] + dx[b_move[step]];
                    b[1] = b[1] + dy[b_move[step]];
                }
            }

        }
        System.out.println(stringBuilder);
    }
}
