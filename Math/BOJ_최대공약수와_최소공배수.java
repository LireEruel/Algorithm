package Math;

import java.io.*;
import java.util.*;

public class BOJ_최대공약수와_최소공배수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a,b);
        int result = 0;
        for (int i = 1; i < max+1; i++) {
            if(a%i == 0 && b %i == 0){
                result = i;
            }
        }
        System.out.println(result);
        System.out.println(a * (b / result));
    }
}
