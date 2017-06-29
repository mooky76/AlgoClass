package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long hi=1, low=1;
		
		for (int i = N; i >= 1; i--) {
			hi*=i;
		}
		
		for (int i = N-K; i >=1; i--) {
			low*=i;
		}
		for (int i = K; i >= 1; i--) {
			low*=i;
		}
		
		System.out.println(hi/low);
		
		
	}
}
