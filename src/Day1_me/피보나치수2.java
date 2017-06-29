package Day1_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치수2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] mm = new int[10000];
		
		mm[1] = mm[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			mm[i] = mm[i-1] + mm[i-2];
		}
		
		System.out.println(mm[n]);
	}

}
