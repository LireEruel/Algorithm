package Queue_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower {
    public static void main(String[] args) throws IOException {

   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int towerLength = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<int[]> stack = new Stack<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < towerLength; i++) {
        int current = Integer.parseInt(st.nextToken());
        
        while (!stack.isEmpty()) {
            if (stack.peek()[0] >= current) {
                sb.append(stack.peek()[1]).append(" ");
                stack.push(new int[] {current, i + 1});
                break;
            }
            stack.pop();
        }
        if (stack.empty()) {
            sb.append("0 ");
            stack.push(new int[] {current, i + 1});
        }
    }
    System.out.println(sb);
}
}
