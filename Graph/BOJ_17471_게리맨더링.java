package Graph;

import java.io.*;
import java.util.*;
public class BOJ_17471_게리맨더링 {
    static class Place {
        int id;
        int peopleCount;
        Set<Integer> nearList;
        Place(int id,int peopleCount, Set<Integer> nearList){
            this.id = id;
            this.peopleCount = peopleCount;
            this.nearList = nearList;
        }
    }
    static int[] parents;
    static Place[] places;
    static int N;
    static int allSum = 0;
    static int make() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parents = new int[N+1];
        places = new Place[N+1];


        for (int i = 1; i < N+1; i++) {
            int count = Integer.parseInt(st.nextToken());
            Place place = new Place(i,count, new HashSet<Integer>());
            places[i]= place;
            parents[i] = i;
            allSum += count;
        }
        int nerds = 0;
        for (int i = 1; i <N+1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) nerds ++;
            for (int j = 0; j < n; j++) {
                int near=Integer.parseInt(st.nextToken());
                places[i].nearList.add(near);
                places[near].nearList.add(i);
            }
        }
        return nerds;
    }

    static void swap(int[]arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean np (int[] p) {

        //1. 맨 뒤쪽부터 탐색하며 꼭대기 찾기
        //2. 꼭대기 직전(i-1)위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
        //3. 꼭대기 직전(i-1)위치의 수와 한단계 큰 수 교환하기.
        //4. 꼭대기자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
        int i = N-1;
        while(i>0 && p[i-1] >= p[i]) i--;
        if(i == 0) return false;
        int j = N-1;
        while(p[i-1] >= p[j]) j--;
        swap(p,i-1,j);
        int l = N-1;
        while(i < l) swap(p,i++,l--);
        return true;
    }

    static boolean bfs(ArrayList<Integer> list)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        int startIndex = list.get(0);
        queue.add(startIndex);
        Set<Integer> selected = new HashSet<>();
        selected.add(startIndex);
        while (!queue.isEmpty())
        {
            Place current = places[queue.poll()];
            count++;
            for (int node: current.nearList ) {
                if(!selected.contains(node) && list.contains(node)){
                    queue.add(node);
                    selected.add(node);
                }
            }
        }
        return count == list.size();
    }

    static ArrayList<ArrayList<Integer>> selectedNodeListSet = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        int nerds = make();
        if(N == 2) {
            System.out.println( Math.abs(places[1].peopleCount - places[2].peopleCount));
            return;
        }
        if (nerds >= 2) {
            System.out.println(-1);
            return;
        }
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i+1;
        }
        for (int r = 1; r < N; r++) {
            int [] set = new int[N];
            // 0보다 큰 값으로 R개를 맨 뒤부터 채운다.
            int cnt = 0;
            while (++cnt <= r)
                set[cnt] = 1;
            Arrays.sort(set);
            do {
                ArrayList<Integer> selectedArr = new ArrayList<Integer>();
                for (int i = 0; i < N; i++) {
                    if(set[i] == 1) {
                        selectedArr.add(i+1);
                    }
                }
                selectedNodeListSet.add(selectedArr);
            }while (np(set));
        }
        int result = -1;

        for (ArrayList<Integer> selectedNodeList : selectedNodeListSet ) {
            boolean valid = bfs(selectedNodeList);
            if (valid) {
                ArrayList<Integer> newList = new ArrayList<>();
                int sum = 0;
                for (int i = 1; i < N+1; i++) {
                    if(!selectedNodeList.contains(i)) {
                        newList.add(i);
                        sum+= places[i].peopleCount;
                    }
                }
                valid =  bfs(newList);
                if(valid) {
                    int diff = Math.abs((allSum - sum)- sum) ;
                    if (result == -1 || diff < result) {
                        result = diff;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
