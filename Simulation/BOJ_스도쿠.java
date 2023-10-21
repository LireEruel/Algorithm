package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_스도쿠 {
    static ArrayList<Set<Integer>> cubeList= new ArrayList<>();
    static ArrayList<Set<Integer>> rowList= new ArrayList<>();
    static ArrayList<Set<Integer>> colList= new ArrayList<>();
    static  int [] nums = new int[81];


   static int dfs (int index, int cubeIndex, int rowIndex, int colIndex){

       int newC, newR;
       if(nums[index] == 0) {
           for (int i = 1; i <= 9; i++) {
//               System.out.println( cubeList.get(cubeIndex).toString() + cubeList.get(cubeIndex).contains(i));
//               System.out.println(rowList.get(rowIndex).contains(i));
//               System.out.println(colList.get(colIndex).contains(i));
               if(!cubeList.get(cubeIndex).contains(i) && !rowList.get(rowIndex).contains(i) && !colList.get(colIndex).contains(i)){
                   cubeList.get(cubeIndex).add(i);
                   rowList.get(rowIndex).add(i);
                   colList.get(colIndex).add(i);
                   nums[index] = i;

                   if(index == 80){
                       return index;
                   }
                   else {
                       if(colIndex == 8){
                           newC = 0;
                           newR = rowIndex+1;
                       }else {
                           newC = colIndex+1;
                           newR = rowIndex;
                       }
                      if(dfs(index+1, ((newR)/3 )*3 + (newC) / 3,newR, newC ) == 80){
                          return 80;
                      }
                   }
                   cubeList.get(cubeIndex).remove(i);
                   rowList.get(rowIndex).remove(i);
                   colList.get(colIndex).remove(i);
               }
           }
           nums[index] = 0;
       }else {
           if (index == 80) {
               return index;
           } else {
               if (colIndex == 8) {
                   newC = 0;
                   newR = rowIndex + 1;
               } else {
                   newC = colIndex + 1;
                   newR = rowIndex;
               }
               if (dfs(index + 1, ((newR) / 3) * 3 + (newC) / 3, newR, newC) == 80) {
                   return 80;
               }
           }
       }
       return index;
   }



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            cubeList.add(new HashSet<>());
            rowList.add(new HashSet<>());
            colList.add(new HashSet<>());
        }
        int index = 0;
        for (int i = 0; i < 9; i++) {
            String[] list = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                int now = Integer.parseInt(list[j]);
                nums[index++] = now;
                int cube = (i/3 )*3 + j / 3;
                if(now != 0){
                   colList.get(j).add(now);
                   rowList.get(i).add(now);
                   cubeList.get(cube).add(now);
                }
            }
        }
        dfs(0, 0,0,0);
        StringBuilder sb = new StringBuilder();
        index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9; j++) {
                sb.append(nums[index++]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
