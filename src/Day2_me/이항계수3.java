package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수3 {
	
	static final int MAXN = 1000000007;
	
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			long result = 1;
			
			for (int i = 1; i <= N; i++) {
				result *= (long)i;
				result %= MAXN;
			}
			
			long b = 1;
			for (int i = 1; i <= K; i++) {
				b *= (long)i;
				b %= MAXN;
			}
			
			for (int i = 1; i <= N-K; i++) {
				b *= (long)i;
				b %= MAXN;
			}
			
			long p = MAXN - 2;
			while (p > 0) {
				if (p % 2 == 1) result = (result * b) % MAXN;
				b = (b*b) % MAXN;
				p /= 2;
			}
			
			System.out.println(result);
	}
}
