package Queue_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yosepus_problem {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        while (queue.size() > 1) {
            count++;
            if (count == K) {
                count = 0;
                sb.append(queue.poll()).append(", ");
            } else {
                queue.offer(queue.poll());
            }
        }
        sb.append(queue.poll()).append(">");

        System.out.println(sb);
    }
}











