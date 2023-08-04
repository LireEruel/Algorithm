package Recursion;

import java.util.Scanner;

public class NandM {

    public static boolean [] selected;
    public static void perm(String[] numArr, int curtLength, int targetLength, int maxNum) {
        if (curtLength == targetLength)
        {
            System.out.println(String.join(" ",numArr));
        }
        else {
            for (int i = 1; i <= maxNum;i++)
            {
                if (selected[i])
                    continue;
                else {
                    numArr[curtLength] = Integer.toString(i);
                    selected[i] = true;
                    perm(numArr, curtLength+1, targetLength, maxNum);
                    selected[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        String [] numArr = new String[M];
        selected = new boolean[N+1];
        perm(numArr, 0, M, N);
    }
}
