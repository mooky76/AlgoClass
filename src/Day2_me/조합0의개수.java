package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합0의개수 {

	static long N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = N - M;
		
		long two = checkNum(N, 2) - checkNum(M, 2) - checkNum(K, 2);
		long five = checkNum(N, 5) - checkNum(M, 5) - checkNum(K, 5);
		
		long result=0;
		if (two > five) {
			result = five;
		}else{
			result = two;
		}
		
		System.out.println(result);

	}

	public static long checkNum(long a, long b) {

		long total = 0;
		long value = 1;
		long multi = b;

		while (value != 0) {
			value = a / multi;
			total += value;
			multi *= b;
		}
		return total;
	}
}
