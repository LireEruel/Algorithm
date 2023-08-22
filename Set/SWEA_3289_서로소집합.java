package Set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
m은 입력으로 주어지는 연산의 개수이다.
다음 m개의 줄에는 각각의 연산이 주어진다.
합집합은 0 a b의 형태로 입력이 주어진다.
이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
a와 b는 n 이하의 자연수이며 같을 수도 있다.
[출력]
각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
입력                 출력
1                   #1 001
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
        */
public class SWEA_3289_서로소집합 {
    static int N;
    static int sets[];

    private static void make() {
        sets = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            sets[i] = i; // 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
        }
    }

    private static int find(int a){
        if(a == sets[a]) return a;
        return sets[a] = find(sets[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        sets[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase < T+1; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("#").append(testCase).append(" ");
            N = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            make();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                boolean isUnion = st.nextToken().equals("0");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (isUnion){
                    union(a, b);
                }
                else {
                    sb.append(find(a) == find(b ) ? 1 : 0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
