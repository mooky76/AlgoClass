package Day1_me;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치수3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long a = 1, b = 1, c = 0, d = 0;
		int mod = 1000000;

		long mat[][] = new long[3][3];
		long mat_temp[][] = new long[3][3];

		mat[1][1] = 1;
		mat[1][2] = 1;
		mat[2][1] = 1;
		mat[2][2] = 0;

		if (n == 0) {
			a = 0;
		} else if (n <= 2) {
			a = 1;
		}
		
		n -= 2;
		while (n > 0) {
			if (n % 2 == 1) {
				c = ((mat[1][1] * a) % mod + (mat[1][2] * b) % mod) % mod;
				d = ((mat[2][1] * a) % mod + (mat[2][2] * b) % mod) % mod;
				a = c;
				b = d;
				n--;
			} else {
				for (int i = 1; i <= 2; i++) {
					for (int j = 1; j <= 2; j++) {
						for (int k = 1; k <= 2; k++) {
							mat_temp[i][j] += mat[i][k] * mat[k][j];
							mat_temp[i][j] = mat_temp[i][j] % mod;
						}
					}
				}

				for (int i = 1; i <= 2; i++) {
					for (int j = 1; j <= 2; j++) {
						mat[i][j] = mat_temp[i][j];
						mat_temp[i][j] = 0;
					}
				}

				n = n / 2;
			}
		}

		System.out.println(a);
	}
}
