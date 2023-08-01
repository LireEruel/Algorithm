package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepairMemory {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcases; i++) {
			String s = br.readLine();
			String curt = "0";
			int count = 0;
			for (int d = 0; d < s.length(); d++) {
				String next = "" + s.charAt(d);
				if (!curt.equals(next)) {
					curt = next;
					count++;
				}
			}
			System.out.printf("#%d %d", i, count);
		}

	}

}
