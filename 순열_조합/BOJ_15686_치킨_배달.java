package 순열_조합;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨_배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [][] board = new int[N][N];
        ArrayList<int[]> shops = new ArrayList<>();
        ArrayList<int[]> homes = new ArrayList<>();
        for (int i = 0;i < N;i++ ) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int current = Integer.parseInt(st.nextToken());
                board[i][j] = current;
                if(current == 2) {
                    shops.add(new int[]{i, j});
                }
                if(current == 1) {
                    homes.add(new int[]{i, j});
                }
            }
        }
        int [] arr = new int [shops.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int[] mask = new int[arr.length];
        int[] res = new int[M];
        for(int i = arr.length - M; i < arr.length; i++){
            mask[i] = 1;
        }
        int result = 0;
        do {
            for(int i = 0, j = 0; i < arr.length ; i++){
                if(mask[i] == 1) res[j++] = arr[i];
            }
            int sum = 0;
            for (int [] home:homes) {
                int x = home[0];
                int y = home[1];
                int min = 0;
                for (int index: res) {
                    int[] shop = shops.get(index);
                    int distance = Math.abs(shop[0] - x) + Math.abs(shop[1] - y);
                    if( min == 0 || distance < min){
                        min = distance;
                    }
                }
                sum += min;
            }
            if(result == 0 || sum < result) {
                result = sum;
            }
        }while(np(mask));
        System.out.println(result);
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

    private static void swap(int[] p, int a, int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
}
