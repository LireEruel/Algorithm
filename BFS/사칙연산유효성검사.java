package BFS;

import java.io.*;
import java.util.*;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
public class 사칙연산유효성검사 {
    public static boolean isNumeric(String s) {
        int curtValue  = (int)s.charAt(0);
        return 48 <= curtValue && curtValue <= 57;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            //tree = new String[N + 1];
            int result = 1;
            Queue<Integer> checkList = new LinkedList<Integer>();
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String current = st.nextToken();
                //tree[i] = st.nextToken();
                
                if (checkList.size() > 0 && i == checkList.peek()) {
                     checkList.poll();
                    if (!isNumeric(current))  {
                        if (i * 2 + 1 <= N ) {
                            checkList.add(i * 2);
                            checkList.add(i * 2 + 1);
                        } else { // 제일 아래인데 숫자가 아닌 경우
                            result = 0;
                        }
                    }
                }else if (!isNumeric(current)) {
                    if (i * 2 + 1 <= N ) {
                        checkList.add(i * 2);
                        checkList.add(i * 2 + 1);
                    } else { // 제일 아래인데 숫자가 아닌 경우
                        result = 0;
                    }
                }
            }
            if (checkList.size() > 0) {
                result = 0;
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
