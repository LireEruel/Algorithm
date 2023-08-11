package TwoPointers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3040_백설_공주와_일곱_난쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num= Integer.parseInt(br.readLine());
            nums[i] = num;
            sum += num;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 8;
        while(left < right) {
            int current = sum - (nums[left] + nums[right]);
            if(current == 100) break;
            if(current > 100) {
                left++;
            }else{
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if(i != left && i != right) {
                sb.append(nums[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
