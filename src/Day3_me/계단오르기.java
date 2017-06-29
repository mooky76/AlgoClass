package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 계단오르기{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int step = Integer.parseInt(br.readLine());

		int C[] = new int[310];

		for (int i = 1; i <= step; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}

		int D[][] = new int[310][3];

		D[1][1] = D[1][2] = C[1];

		for (int i = 2; i <= step; i++) {
				D[i][1] = D[i - 1][2] + C[i];
				D[i][2] = Math.max(D[i - 2][1], D[i - 2][2]) + C[i];
		}

		System.out.println(Math.max(D[step][1], D[step][2]));

	}
}
