package Day4_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐의추측 {

	static int prime[] = new int[1000010];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 2; i <= 1000000; i++) {
			for (int j = 2; j * i < 1000000; j++) {
				if (prime[i * j] == 1)
					continue;
				prime[i * j] = 1;
			}
		}

		char flag = 'Y';
		int a, b = 0;
		while (flag == 'Y') {
			a = 0;
			int N = Integer.parseInt(br.readLine());
			if (N != 0) {
				for (int i = 3; i < N; i++) {
					if (prime[i] == 0) {
						if (prime[N-i] == 0) {
							a = i;
							b = N-i;
							break;
						}
					}
				}
				if (a != 0) {
					System.out.println(N +" = " + a +" + " + b);					
				}else{
					System.out.println("Goldbach's conjecture is wrong.");
				}

			} else {
				flag = 'N';
			}
		}
	}
}
