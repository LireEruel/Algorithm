package Queue_Stack;

import java.io.*;
import java.util.*;

public class BOJ_15961_회전_초밥 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = k;
        Map<Integer, Integer> currentInfo = new HashMap<>();
        int[] belt = new int[N];
        int max= 0;
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            int curt = belt[i];
            if(currentInfo.containsKey(curt)){
                currentInfo.put(curt, currentInfo.get(curt)+1);
            }else {
                currentInfo.put(curt,1);
            }
        }
        for(int i = 0; i < N; i++ ){
            int leftValue = belt[left];
            int rightValue = belt[right];

            if(currentInfo.get(leftValue) == 1) {
                currentInfo.remove(leftValue);
            }else currentInfo.put(leftValue, currentInfo.get(leftValue)-1);

            if(currentInfo.containsKey(rightValue)){
                currentInfo.put(rightValue, currentInfo.get(rightValue)+1);
            }else {
                currentInfo.put(rightValue,1);
            }
            int typeCount = currentInfo.size();
            if(!currentInfo.containsKey(c)) typeCount +=1;
            if (max < typeCount) {
                max = typeCount;
            }
            left++;
            right =(right+1)%N;
        }
        System.out.println(max);

    }
}
