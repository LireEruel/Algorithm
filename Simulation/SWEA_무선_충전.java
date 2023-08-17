package Simulation;

import java.io.*;
import java.util.*;

public class SWEA_무선_충전 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase < T+1; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int bcCount = Integer.parseInt(st.nextToken());
            String[] sa = br.readLine().split(" ");
            String[] sb = br.readLine().split(" ");
            int [] a = new int[t];
            int [] b = new int[t];

            for (int i = 0; i < bcCount; i++) {
                a[i] = Integer.parseInt(sa[i]);
                b[i] = Integer.parseInt(sb[i]);
            }
            ArrayList<Integer>[] board= new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                board[i] = new ArrayList<Integer>();
            }

            // 같은 BC인 경우 다른 BC 접속 가능하면 각각 다른데로 옮길 수 있는지 확인하고 가능하면 옮긴다.
            for (int i = 0; i < bcCount; i++ ){
                st = new StringTokenizer(st.nextToken());
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                int c = Integer.parseInt(br.readLine());
                int p = Integer.parseInt(br.readLine());


            }
        }
        

    }
}
