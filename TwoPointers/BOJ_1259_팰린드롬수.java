package TwoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1259_팰린드롬수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String row= br.readLine();
            String strings[] = row.split("");
            if(row.equals("0"))break;
            int[] nums = new int[row.length()];
            for (int i = 0; i < row.length(); i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            int left = 0;
            int right = nums.length-1;
            boolean valid = true;
            while(left < right){
                if(nums[left++] != nums[right--]) {
                    valid = false;
                    break;
                }
            }
            if(valid) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
