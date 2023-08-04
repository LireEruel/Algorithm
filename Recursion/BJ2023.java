package Algorithm.Recursion;

import java.util.Scanner;

public class BJ2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();


    public static boolean isFew(int number) {
        if (number <= 1) return false; // 1 이하의 수는 소수가 아님
        if (number == 2) return true; // 2는 소수
        if (number % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false; // 나누어 떨어지는 수가 있으면 소수가 아님
            }
        }
        return true; // 나누어 떨어지는 수가 없으면 소수
    }

    public static void findFew(int cnt, int current) {
        if(cnt == N){
           sb.append(current).append("\n");
        } else {
            for (int i = 1; i <= 9 ; i+=2) {
                int temp = current*10 + i;
                if( isFew(temp)){
                    findFew(cnt +1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int[] fews = new int [] {2,3,5,7};
        for(int i = 0; i < 4;i++) {
            findFew(1, fews[i]);
        }
        System.out.println(sb.toString());
    }

}
