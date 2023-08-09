package Simulation;

import java.io.*;
import java.util.*;

public class 색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] 도화지 = new boolean[100][100];
        int 넓이 = 0;

        int 색종이개수 = Integer.parseInt(br.readLine());

        for (int 색종이 = 0; 색종이 < 색종이개수; 색종이++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            for (int x = startX; x < startX + 10; x++) {
                for (int y = startY; y < startY + 10; y++) {
                    if (x < 100 && y < 100 && !도화지[x][y]) {
                        도화지[x][y] = true;
                        넓이++;
                    }
                }
            }
        }
        System.out.println(넓이);
    }
}
