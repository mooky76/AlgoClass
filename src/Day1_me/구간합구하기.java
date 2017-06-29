package Day1_me;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {

	static long tree[] = new long[4 * 1000000 + 10];
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int sz = 1;
		for (sz = 1; sz <= N; sz *= 2);
		sz--;

		for (int i = 1; i <= N; i++) {
			tree[sz + i] = Integer.parseInt(br.readLine());
		}

		for (int i = sz; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}

		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {

				long diff = (long) c - tree[sz + b];
				int idx = sz + b;
				while (idx >= 1) {
					tree[idx] += diff;
					idx /= 2;
				}
			} else {
				int left = sz + b;
				int right = sz + c;

				long result = 0;
				while (left <= right) {
					if (left % 2 == 1)
						result += tree[left];
					if (right % 2 == 0)
						result += tree[right];
					left += 1;
					left /= 2;
					right -= 1;
					right /= 2;
				}
				System.out.println(result);
			}
		}
	}
}
