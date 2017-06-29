package Day1_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

	static int N, M;
	static int[] array;
	static int result;

	public static void main(String[] args) throws Exception {

		result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int imsi;
		for (int i = 0; i < array.length; i++) {
			imsi = array[i];
			if (imsi == M) {
				result++;
				continue;
			}
			for (int j = i + 1; j < array.length; j++) {
				imsi += array[j];
				if (imsi > M) {
					break;
				} else if (imsi == M) {
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
