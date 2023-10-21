package BFS;

import java.io.*;
import java.util.*;

public class SWEA_5643_키_순서 {

    static class Member {
        int id;
        Set<Member> shortList;
        Set<Member> longList;

        Member(int id) {
            this.id = id;
            this.shortList = new HashSet<>();
            this.longList = new HashSet<>();
        }
    }
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\portfolio\\Algorithm\\input.txt")));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase < T+1; testCase++) {
            ArrayList<Member> memberList = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            for (int i = 0; i < N+1; i++) {
                memberList.add(new Member(i));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                Member memA = memberList.get(a);
                Member memB = memberList.get(b);

                memA.longList.add(memB);
                memB.shortList.add(memA);
            }
            int result = 0;
            for (Member curtM:memberList) {
                Set <Integer> s = new HashSet<>();
                Set <Integer> l = new HashSet<>();
                boolean[] visited = new boolean[N+1];

                Deque<Member> q = new ArrayDeque<>(curtM.shortList);
                while (!q.isEmpty()){
                    Member m = q.poll();
                    s.add(m.id);
                    if(visited[m.id]) continue;
                    visited[m.id] = true;
                    for (Member mem: m.shortList) {
                        if(!visited[mem.id]) {
                            q.add(mem);
                        }
                    }
                }
                visited = new boolean[N+1];
                q.addAll(curtM.longList);
                while (!q.isEmpty()){
                    Member m = q.poll();
                    l.add(m.id);
                    if(visited[m.id]) continue;
                    visited[m.id] = true;
                    for (Member mem: m.longList) {
                        if(!visited[mem.id]) {
                            q.add(mem);
                        }
                    }
                }

                if(s.size() + l.size() == N-1){
                    result++;
                }
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
