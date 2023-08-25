package Simulation;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14215_세막대 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[]nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = s.nextInt();
        }
        Arrays.sort(nums);
        if(nums[2] >= nums[0] + nums[1]){
            nums[2] = nums[0] + nums[1] -1;
        }

        System.out.println(nums[0] + nums[1] + nums[2]);
    }
}
