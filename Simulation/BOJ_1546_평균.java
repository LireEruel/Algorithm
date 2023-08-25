package Simulation;

import java.util.Scanner;

public class BOJ_1546_평균 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        double[] arr = new double[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int now = s.nextInt();
            arr[i] = now;
            if(max < now) max= now;
        }

        double aver = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i]/max*100;
            aver+=arr[i];
        }
        aver/=N;
        System.out.println(aver);
    }
}
