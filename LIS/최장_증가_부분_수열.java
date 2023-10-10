package LIS;

import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.StringTokenizer;

public class 최장_증가_부분_수열 {
    public static int bisearch(ArrayList<Integer> lis, int num) {
        int lo = 0;
        int mid;
        int hi = lis.size();

        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (num > lis.get(mid))
                lo = mid + 1;
            else {
                hi = mid;
            }
        }
        return hi;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase < T+1; testCase++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
            int now;
            for (int i = 0; i < N-1; i++) {
                now = Integer.parseInt(st.nextToken());

                if(list.get(list.size()-1) < now){
                    list.add(now);
                }else {
                    list.set(bisearch(list, now), now);
                }
            }
            sb.append("#").append(testCase).append(" ").append(list.size()).append("\n");
        }
        System.out.println(sb);
    }
}