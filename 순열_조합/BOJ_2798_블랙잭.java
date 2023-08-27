package 순열_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

    static int N, target;

    public static void swap(int p[], int a, int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
    private static boolean np(int[] p ){ // 다음 순열을 원하는 기존 순열의 배열
        //1. 맨 뒤쪽부터 탐색하며 꼭대기 찾기
        int N = p.length;
        int i = N-1;
        while(i > 0 && p[i-1] >= p[i]) --i;

        if(i==0) return false; // 다음 순열은 없음(가장 큰 순열의 형태)

        //2. 꼭대기 직전(i-1)위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
        int j = N-1;
        while(p[i-1] >= p[j]) --j;

        //3. 꼭대기 직전(i-1)위치의 수와 한단계 큰 수 교환하기.
        swap(p, i-1, j);

        //4. 꼭대기자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
        int k = N-1;
        while(i < k){
            swap(p, i++ , k--);
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];
        arr[N-1] = 1;
        arr[N-2] = 1;
        arr[N-3] = 1;
        int result = 0;
        do {
            int sum= 0;
            for (int index=0; index < N; index++ ) {
                if(arr[index] == 1) {
                    sum+= cards[index];
                }
            }
            int diff = target - sum;
            if(diff >-1 && diff < target-result){
                result = sum;
            }
        }while(np(arr));
        System.out.println(result);
    }
}
