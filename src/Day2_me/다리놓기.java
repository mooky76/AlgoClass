package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

	static long[][] memo = new long[31][31];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.println(combi(M, N)%1000000007);
		}

	}

	public static long combi(int n, int k) {

		if (n == k || k == 0)
			return 1;
		if (memo[n][k] != 0)
			return memo[n][k];

		memo[n][k] = (combi(n - 1, k - 1)%1000000007 + combi(n - 1, k)%1000000007)%1000000007;
		return memo[n][k];
	}
}
