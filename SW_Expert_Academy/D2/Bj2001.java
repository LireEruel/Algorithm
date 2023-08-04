package SW_Expert_Academy.D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Bj2001 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\portfolio\\Algorithm\\input.txt");
        Scanner scanner = new Scanner(new FileReader(file));
        int T = scanner.nextInt();
        for (int testcase = 1; testcase <= T; testcase++) {
            int size = scanner.nextInt();
            int power = scanner.nextInt();
            int[][] board = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            int catch_max = 0;

            for (int x = 0; x < size-power+1; x++) {
                for (int y = 0; y < size-power+1; y++) {
                    int sum = 0;
                    for(int i = x; i < x+power;i ++){
                        for(int d = y; d < y+power;d ++){
                            sum += board[i][d];
                        }
                    }
                    if(catch_max < sum){
                        catch_max = sum;
                    }
                }
            }
            System.out.println("#" + testcase + " " + catch_max);
        }
        scanner.close();
    }
}
