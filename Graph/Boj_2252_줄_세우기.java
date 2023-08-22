package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2252_줄_세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M,N;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int [] edgeCnt = new int[N+1];
        edgeCnt[0] = -1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeCnt[b]++;
            graph.get(a).add(b);
        }


        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(edgeCnt[i] == 0)
                q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            int top = q.poll();
            sb.append((top)).append(" ");
            ArrayList<Integer> current = (ArrayList<Integer>) graph.get(top);
            for (int next : current) {
                edgeCnt[next]--;
                if (edgeCnt[next] == 0) {
                    q.add(next);
                }
            }
        }


        System.out.println(sb);
    }
}
