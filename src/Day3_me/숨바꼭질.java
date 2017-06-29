package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질 {

	static long tree[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new long[4 * N + 10];

		int sz = 1;
		for (sz = 1; sz <= N; sz++)
			;
		sz--;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			tree[sz+i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = sz; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[i*2 +1];
		}
		
		long result = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			left +=sz;
			right+=sz;
			
			
		}
		
	}
}
