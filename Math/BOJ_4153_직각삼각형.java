package Math;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_4153_직각삼각형 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[3];
        while(true){
            nums[0] = s.nextInt();
            nums[1] = s.nextInt();
            nums[2]= s.nextInt();
            Arrays.sort(nums);
            if( nums[0]  + nums[1]  +nums[2] == 0) break;
            if(Math.pow(nums[0],2) + Math.pow(nums[1],2) == Math.pow(nums[2],2)){
                System.out.println("right");
            }else System.out.println("wrong");
        }
    }
}
