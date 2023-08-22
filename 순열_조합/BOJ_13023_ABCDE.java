package 순열_조합;
import java.io.*;
import java.util.*;



public class BOJ_13023_ABCDE {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean dfs(int[] selected, int current, int count ){
        ArrayList<Integer> friends = graph.get(current);

        if(count == 5){
            return true;
        }
        for (int friend: friends ) {
            if(selected[friend] == 0) {
                boolean result = dfs(selected, friend, count+1);
                if(result)
                    return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
}
