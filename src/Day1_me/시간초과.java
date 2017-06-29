package Day1_me;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간초과 {

	static String S, result;
	static int N, T, L;
	static long before, after;
	static long P = 100000000;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			S = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			after = P * L;
			before = 1; 
			
			if ("O(N)".equals(S)) {
				before = N * T;
			} else if ("O(N^2)".equals(S)) {
				before = (long)Math.pow(N, 2) * T;
			} else if ("O(N^3)".equals(S)) {
				before = (long)Math.pow(N, 3) * T;
			} else if ("O(2^N)".equals(S)) {
				before = (long)Math.pow(2, N) * T;
			} else if ("O(N!)".equals(S)) {
				for (int i = N; i >= 1; i--) {
					before *= i;
					if (before > after) {
						after = 1;
						break;
					}
				}
				before *= T;
			}
			
			result = check(before, after);
			System.out.println(result);
		}
	}
	
	public static String check(long before, long after){
		
		if (before * -1 > 0) return "TLE!";
		
		if (before > after) {
			return "TLE!";
		}else{
			return "May Pass.";
		}
	}
}
