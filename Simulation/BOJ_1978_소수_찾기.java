package Simulation;

import java.io.*;
import java.util.*;

public class BOJ_1978_소수_찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int [] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int curt = Integer.parseInt(st.nextToken());
            nums[i] = curt;
            if(max<curt){
                max = curt;
            }
        }
        int[] primes = new int[max+1];
        primes[0] = 1;
        primes[1] = 1;
        primes[2] = 0;
        int index = 2;
        while(Math.pow(index,2 ) <= max){
            if(primes[index] == 0){
                int pow = 2;
                while(index * pow <=max){
                    primes[index * pow] = 1;
                    pow++;
                }
            }
            index++;
        }
        int result = 0;

        for (int num: nums ) {
            if(primes[num] == 0) result++;
        }
        System.out.println(result);
    }
}
