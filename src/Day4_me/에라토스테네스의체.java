package Day4_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {

	static int prime[] = new int[1010];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int deleteNum = 0;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j * i <= N; j++) {
				if (prime[i * j] == 1) continue;
				prime[i * j] = 1;
				deleteNum++;
				if (deleteNum == K) {
					System.out.println(i * j);
				}
			}
		}
	}
}
