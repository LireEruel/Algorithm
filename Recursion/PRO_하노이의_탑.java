package Recursion;

import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<int[]>answer = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> towers = new ArrayList<>();

    public static void move(int start, int destination, int depth){
        if(depth == 1) {
            int temp = towers.get(start).get(0);
            towers.get(start).remove(0);
            towers.get(destination).add(temp);
            int [] arr = new int[2];
            arr[0] = start+1;
            arr[1] = destination+1;
            answer.add(arr);
        }else {
            int tempIndex = 3 - (start + destination);
            move(start, tempIndex, depth-1);
            move(start, destination, 1);
            move(tempIndex, destination, depth-1);
        }
    }

    public static int[][] solution(int n) {
        move(0,2,n);

        return (int[][]) answer.toArray();
    }

    public static void main(String[] args) {
        System.out.println( solution(2));
    }
}