package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_16435_스네이크버드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] foods = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(foods);
        for (int food: foods ) {
            if(food <= height) {
                height++;
            }else {
                break;
            }
        }
        System.out.println(height);
    }
}
