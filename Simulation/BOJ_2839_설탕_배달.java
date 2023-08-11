package Simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839_설탕_배달 {
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum =  Integer.parseInt(br.readLine());
        int heavy = sum/5;
        int answer = -1;
        for (int i = heavy; i >-1 ; i--) {
            if((sum - i*5) % 3 == 0) {
                answer = i + (sum - i * 5)/3;
                break;
            }
        }
        System.out.println(answer);
    }
}
