package Graph;

import java.io.*;
import java.util.*;

public class SWEA_하나로 {
        static class Edge implements Comparable<Edge> {
            int from, to;
            double weight;

            public Edge(int from, int to, double weight){
                super();
                this.from = from;
                this.to = to;
                this.weight = weight;
            }
            @Override
            public int compareTo(Edge o) {
                return Double.compare(weight,o.weight);
            }
        }
        static Edge[] edgeList;
        static int[] parents ;
        static void make(int N) {
            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        static int find(int a) {
            if(parents[a] == a) return a;
            return parents[a] = find(parents[a]);
        }

        static boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB ) return false;
            parents[rootB] = rootA;
            return true;
        }

        public static void main(String[]args)throws Exception{
            BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int testCase = 1; testCase < T+1; testCase++) {
                int N = Integer.parseInt(br.readLine());
                int[][] islands = new int[N][2];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    islands[i][0] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    islands[i][1] = Integer.parseInt(st.nextToken());
                }
                double E = Double.parseDouble(br.readLine());

                // 엣지 생성
                //연서언니가 했길래 ㅎㅎ
                int cntEdge = N * (N-1)/2;
                edgeList = new Edge[cntEdge];
                int idx = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = i+1; j < N; j++) {
                        long xDiff = Math.abs( islands[i][0] - islands[j][0]);
                        long yDiff = Math.abs( islands[i][1] - islands[j][1]);
                        double w =  (Math.pow(xDiff, 2) + Math.pow(yDiff,2)) * E;
                        Edge edge = new Edge(i,j,w);
                        edgeList[idx++] = edge;
                    }
                }

                Arrays.sort(edgeList);

                make(N);
                double sum = 0;
                int count = 0;
                for (Edge edge: edgeList ) {
                    int a = edge.from;
                    int b = edge.to;
                    if(union(a,b)){
                        sum += edge.weight;
                        if(++count== N-1) break;
                    }
                }

                sb.append("#").append(testCase).append(" ").append(Math.round(sum)).append("\n");
            }
            System.out.println(sb);
        }
    }
