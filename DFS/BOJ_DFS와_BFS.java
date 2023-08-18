package DFS;

import java.io.*;
import java.util.*;

public class BOJ_DFS와_BFS {
    static int V,M,N;

    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

    static HashSet<Integer> selected = new HashSet<>();
    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        selected.clear();
        selected.add(V);
        queue.add(V);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node).append(" ");
            selected.add(node);
            ArrayList<Integer> list = graph.get(node);
            if(list != null) {
                list.sort(Comparator.naturalOrder());
                for (int n : list) {
                    if (!queue.contains(n) && !selected.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }
        System.out.println(sb);
    }

    static void dfs() {
        Stack<Integer> stack = new Stack<>();
        selected.clear();
        selected.add(V);
        stack.push(V);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            int node = stack.pop();
            if(node == V ||!selected.contains(node)){
                sb.append(node).append(" ");
                selected.add(node);
                ArrayList<Integer> list = graph.get(node);
                if(list != null) {
                    list.sort(Comparator.reverseOrder());
                    for (int n : list ) {
                        if(!selected.contains(n)){
                            stack.push(n);
                        }
                    }
                }

            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(graph.containsKey(a)){
                graph.get(a).add(b);
            }
            else {
                graph.put(a, new ArrayList<Integer>());
                graph.get(a).add(b);
            }
            if(graph.containsKey(b)){
                graph.get(b).add(a);
            }
            else {
                graph.put(b, new ArrayList<Integer>());
                graph.get(b).add(a);
            }
        }
        selected.clear();
        selected.add(V);
        dfs();
        bfs();
    }
}
