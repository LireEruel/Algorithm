package 순열_조합;

import java.util.*;
import java.io.*;
public class SWEA_0810_규영이와_인영이의_카드게임 {

    static int[] cards1 = new int[8];
    static int[] cards2 = new int[8];
    static int loss, win;

    static void calc(int cnt, int[] selected){
        if(cnt < 8){
            for (int i = 0; i < 8; i++) {
                if(selected[i] == 0) {
                    if(cards1[i]> cards2[i])  {
                        win++;
                    }
                    else {
                        loss--;
                    }
                    selected[i] = 1;
                }
                calc(cnt+1,selected);
            }
        }
    }
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase= 1 ; testCase < T+1; testCase++) {
            loss = 0;
            win = 0;
            sb.append("#").append(testCase).append(" ");
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < 8; i++) {
                cards1[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < 17; i++) {
                int index = 0;
                boolean isContain = false;
                for (int a: cards1) {
                    if( a == i) {
                        isContain = true;
                        break;
                    }
                }
                if(!isContain){
                    cards2[index] = i;
                    index++;
                }
            }
            calc(0, new int[9]);
            sb.append(win).append(" ").append(loss).append("\n");
        }
        System.out.println(sb);
    }
}
