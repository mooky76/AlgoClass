package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int array[] = new int[1010];
		int D[] = new int[1010];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			int min = 0;
			for (int j = 1; j <= i; j++) {
				if (array[i] > array[j]) {
					if (min < D[j]) {
						min = D[j];
					}
				}
			}
			D[i] = min + 1;
			if (max < D[i]) {
				max = D[i];
			}
		}

		System.out.println(max);

	}
}
