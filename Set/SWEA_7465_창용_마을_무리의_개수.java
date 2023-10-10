package Set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class SWEA_7465_창용_마을_무리의_개수 {
    static int[] nums;
    static int N, M;

    static void setting() {
        for (int i = 1; i < N+1; i++) {
            nums[i] = i;
        }
    }

    static int find(int num) {
        if(nums[num] == num){
            return num;
        }
        else {
            return  nums[num] = find(nums[num]);
        }
    }

    static void union(int a, int b){
        int headA = find(a);
        int headB = find(b);

        if(headA != headB){
            nums[headB] = headA;
        }
    }

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\SSAFY\\IdeaProjects\\Algorithm\\input.txt")));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        for(int testCase = 1; testCase < T+1;testCase++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nums = new int[N+1];
            setting();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            int size = 0;
            for (int i = 1; i < N+1; i++){
                if(nums[i] == i){
                    size++;
                }
            }
            System.out.println(Arrays.toString(nums));
            sb.append("#").append(testCase).append(" ").append(size).append("\n");
        }
        System.out.println(sb);
    }
}
