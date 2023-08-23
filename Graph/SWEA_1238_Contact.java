package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class SWEA_1238_Contact {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase < 11; testCase++) {
            sb.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dataLength = Integer.parseInt(st.nextToken())/2;
            int startNode = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new ArrayDeque<>();
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < dataLength; index++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if(graph.containsKey(from)){
                    graph.get(from).add(to);
                }
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(to);
                    graph.put(from, list);
                }
                if(!graph.containsKey(to)) {
                    graph.put(to, new ArrayList<>());
                }
            }
            queue.add(new int[]{startNode, 0});
            int result = startNode;
            int curtDept = 0;
            Set<Integer> selected = new HashSet<>();
            while (!queue.isEmpty()){
                int[] node = queue.poll();
                if(curtDept < node[1] || result < node[0]) {
                    curtDept = node[1];
                    result = node[0];
                }
                for (int nextNode: graph.get(node[0]) ) {
                    if(!selected.contains(nextNode)){
                        queue.add(new int[]{nextNode, node[1]+1});
                        selected.add(nextNode);
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
