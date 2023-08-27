package Queue_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader( System.in));
        Stack<String> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            switch (operator){
                case "push":
                    stack.push(st.nextToken());
                    break;
                case "top":
                    System.out.println(stack.empty() ? "-1" :stack.peek());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "pop":
                    System.out.println(stack.empty() ? "-1" :stack.pop());
                    break;
                case "empty":
                    System.out.println(stack.empty() ? 1 : 0);
                    break;
            }
        }
    }
}
