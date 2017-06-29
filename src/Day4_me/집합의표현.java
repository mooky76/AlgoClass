package Day4_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  집합의표현 {

	static int r[] = new int[1000010];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			r[i] = i;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0) {
				join(b, c);
			} else {
				if (group(b) == group(c)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	public static int group(int node) {
		if (r[node] == node)
			return node;
		return r[node] = group(r[node]);
	}

	public static void join(int a, int b) {
		int ga = group(a);
		int gb = group(b);
		if (ga == gb)
			return;
		r[ga] = gb;
	}
}
