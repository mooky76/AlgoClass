package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수2 {

	static long[][] memo = new long[1010][1010];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(combi(N, K)%10007);
	}

	public static long combi(int n, int k) {

		if (n == k || k == 0)
			return 1;
		if (memo[n][k] != 0)
			return memo[n][k];

		memo[n][k] = (combi(n - 1, k - 1)%10007 + combi(n - 1, k)%10007)%10007;
		return memo[n][k];
	}
}
