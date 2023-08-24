package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MSTKruskalTest {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight){
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // return this.weight - o.weight; 이 코드도 가능하지만 overflow나 여러 크고작음으로 발생하는 문제들이 생길 수 있다.
            return Integer.compare(this.weight, o.weight); // edgecase 방지를 위해 Integer.compare을 사용하면 유용하다.
        }
    }
    static Edge[] edgeList;
    static int V,E;
    static int[] parents;
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    private static void make() {
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i; // 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
        }
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }

        // 간선리스트를 가중치 기준 오름차순 정렬
        Arrays.sort(edgeList);

        //V개의 정점으로 make set 작업
        make();

        int result = 0;// MST 비용
        int count = 0; // 연결된 간선 개수
        for (Edge edge : edgeList){ // 비용이 작은 간선순으로 꺼내서어 처리
            if(union(edge.from, edge.to)){
                result += edge.weight;
                if(++count == V-1) break;
            }
        }
        System.out.println(result);

    }
}
