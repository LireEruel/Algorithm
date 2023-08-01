package Simulation;

import java.io.File;
import java.util.Scanner;

//SWEA Flatten
class Solution {
    public static void main(String args[]) throws Exception {
        // File file = new File("src\\input.txt");
        // Scanner sc = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        int dumpsCount;
        int[] dumps;
        int maxDump = 1;
        int minDump = 100;
        for (int test_case = 1; test_case <= T; test_case++) {
            dumpsCount = sc.nextInt();
            dumps = new int[101];
            for (int i = 0; i < 100; i++) {
                int dump = sc.nextInt();
                dumps[dump]++;
                if (maxDump < dump)
                    maxDump = dump;
                if (minDump > dump)
                    minDump = dump;
            }
            while (dumpsCount > 0) {
                int max = dumps[maxDump];
                int min = dumps[minDump];
                int diff = Math.min(max, min);
                if (dumpsCount < diff) {
                    diff = dumpsCount;
                }
                dumps[maxDump] -= diff;
                dumps[maxDump - 1] += diff;
                dumps[minDump] -= diff;
                dumps[minDump + 1] += diff;
                dumpsCount -= diff;
                if (max - diff == 0) {
                    maxDump--;
                }
                if (min - diff == 0) {
                    minDump++;
                }
            }
            System.out.println("#" + test_case + " " + (maxDump - minDump));
        }
    }
}