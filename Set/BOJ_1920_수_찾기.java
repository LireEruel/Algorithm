package Set;

import java.io.*;
import java.util.*;
public class BOJ_1920_수_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            set.add(st.nextToken());
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String curt = st.nextToken();
            if(set.contains(curt))
                System.out.println(1);
            else System.out.println(0);
        }
    }
}
