package 코테입문.자바_기본_문법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class triangle {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());


        // 가로가 width 인 오른쪽 정렬된 삼각형 출력하기
        System.out.println("가로가 width 인 오른쪽 정렬된 삼각형 출력하기");
        for (int i = 1; i <= size; i++) {
            for (int d = 1; d <= size - i; d++) {
                System.out.print(" ");
            }
            for (int d = size - i; d < size; d++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        System.out.println("n줄의 정삼각형 출력하기");
        for (int i = 1; i <= size; i++)
        {
            for (int d = 1; d <= size - i; d++) {
                System.out.print(" ");
            }
            for (int d = 0; d < i * 2 - 1; d++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        // 정삼각형 별찍기

        System.out.println("역삼각형 별찍기");
        for (int i = size; i >= 1; i--) {
            for (int j = 0; j < size - i; j++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    
    }
}