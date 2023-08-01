package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SwitchOnOff {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int switchLength = Integer.parseInt(bf.readLine());
        String [] switchArr = new String[switchLength+1];
        switchArr[0] = "";
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 1; i <= switchLength; i++)
        {
            switchArr[i] = st.nextToken();
        }
        int studentNum = Integer.parseInt(bf.readLine());
        for(int i = 0; i <studentNum; i++) {
            String[] values = bf.readLine().split(" ");
            if(values[0].equals("1")) {
                int value = Integer.parseInt(values[1]);
                for(int d = value; d < switchArr.length; d+=value) {
                    switchArr[d] = switchArr[d].equals("1") ? "0" : "1";
                }
            }
            else {
                int mid = Integer.parseInt(values[1]);
                int left = mid;
                int right = mid;
                boolean isSymmetry = false;
                while(true) {
                    if((left-1 > 0) && (right +1 < switchArr.length) && (switchArr[left-1].equals(switchArr[right+1]))) {
                        isSymmetry = true;
                        left--;
                        right++;
                    }
                    else{
                        break;
                    }
                }
                if(isSymmetry){
                    for(int d = left; d <= right; d++) {
                        switchArr[d] = switchArr[d].equals("1") ? "0" : "1";
                    }
                }else {
                    switchArr[mid] = switchArr[mid].equals("1") ? "0" : "1";
                }
            }
        }
        s = String.join(" ", switchArr);
        s = s.substring(1);
        int length = 40;
        for (int i = 0; i < s.length(); i += length) {
            int end = Math.min(i + length, s.length()); // 마지막 부분 처리
            String part = s.substring(i, end);
            System.out.println(part);
        }
    }
}
