package Day4_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호제작 {
	
	static int prime[] = new int[10000010];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 2; i <= K; i++) {
			for (int j = 2; j * i <= K; j++) {
				if (prime[i*j] == 1) continue;
				prime[i*j] = 1;
			}
		}
		String result = "GOOD";
		for (int i = K; i >= 1; i--) {
			if (prime[i] == 0) {
				// i �� ������ �������� bad �ϰ� break;
				if (P%i == 0) {
					result = "BAD";
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
