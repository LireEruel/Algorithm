package Array_String;

import java.io.*;
import java.util.*;

public class BOJ_2751_수_정렬하기_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int num: nums) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
