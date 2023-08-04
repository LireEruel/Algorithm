package Recursion;

import java.util.Scanner;

public class NandM2 {

    public static boolean [] selected;
    public static String[] numArr;
    public static int maxNum;
    public static int targetLength;

    public static void perm(int curtLength, int curt) {
        if (curtLength == targetLength)
        {
            System.out.println(String.join(" ",numArr));
        }
        else {
            for (int i = curt; i <= maxNum;i++)
            {
                if (selected[i])
                    continue;
                else {
                    numArr[curtLength] = Integer.toString(i);
                    selected[i] = true;
                    perm(curtLength+1, i+1);
                    selected[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        maxNum = s.nextInt();
        targetLength = s.nextInt();
        numArr = new String[targetLength];
        selected = new boolean[maxNum+1];
        perm(0, 1);
    }
}
