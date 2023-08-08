package TwoPointers;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와_Spot_Mart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N;
        int M;
        int[] snacks;
        int left;
        int right;
        int max;

        for (int T = 1; T <= TC; T++) {
            max = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            snacks = new int[N];

            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);

            left = 0;
            right = N - 1;

            while (left < right) {
                int current = snacks[left] + snacks[right];
                if (current > M) {
                    right--;
                } else {
                    if (current > max) {
                        max = current;
                    }
                    left++;
                }
            }

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
