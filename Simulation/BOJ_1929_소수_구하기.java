package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_1929_소수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N =sc.nextInt();

        int[] primes = new int[N+1];

        primes[0] = 1;
        primes[1] = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N+1; i++) {
            if(primes[i] == 0){
                if(i >= M){
                    sb.append(i).append("\n");
                }
                for (int j = 2; j*i < N+1; j++) {
                    primes[i*j] = 1;
                }
            }
        }
        System.out.println(sb);
    }
}
