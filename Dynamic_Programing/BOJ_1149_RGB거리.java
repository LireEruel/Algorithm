package Dynamic_Programing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
    static int[][] houseArr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        houseArr = new int[3][N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        houseArr[0][0] = Integer.parseInt(st.nextToken());
        houseArr[1][0] = Integer.parseInt(st.nextToken());
        houseArr[2][0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            houseArr[0][i] = Math.min(houseArr[1][i-1], houseArr[2][i-1])+r;
            houseArr[1][i] = Math.min(houseArr[0][i-1], houseArr[2][i-1])+g;
            houseArr[2][i] = Math.min(houseArr[0][i-1], houseArr[1][i-1])+b;
        }
        System.out.println(Math.min(houseArr[0][N-1], Math.min(houseArr[1][N-1], houseArr[2][N-1])));

    }
}
