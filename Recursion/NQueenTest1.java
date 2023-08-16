package Recursion;

import java.util.Scanner;

public class NQueenTest1 {
    static int N, col[], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        col = new int[N+1];
        ans = 0;

        setQueen(1);
        System.out.println(ans);
    }
    private static void setQueen(int row){

        //가지치기
        if(!isAvaillable(row)) return;
        //가지조건
        if(row > N) {
            ans++;
            return;
        }

        //유도파트
        for(int c = 1; c <= N; c++){
            col[row] = c;
            setQueen(row + 1);
        }
        setQueen(row+1);
    }

    private static boolean isAvaillable(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row] || row -i == (int)Math.abs(col[row] - col[i])) {
                 return false;
            }
        }
        return true;
    }
}
