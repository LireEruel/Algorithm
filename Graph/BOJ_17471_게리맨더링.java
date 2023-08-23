package Graph;

import java.io.*;
import java.util.*;
public class BOJ_17471_게리맨더링 {
    public static void main(String[] args) throws Exception {
        class Place {
            int id;
            int peopleCount;
            ArrayList<Integer>[] near;
            Place(int id,int peopleCount){
                this.id = id;
                this.peopleCount = peopleCount;
            }
        }
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int N = Integer.parseInt(br.readLine());
        Place[] places = new Place[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int count = Integer.parseInt(st.nextToken());
            Place place = new Place(i,count );
            places[i]= place;
        };


    }
}
