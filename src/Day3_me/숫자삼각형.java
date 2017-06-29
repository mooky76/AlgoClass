package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자삼각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int tri[][] = new int[N+1][N+1];
		
		StringTokenizer st;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				st = new StringTokenizer(br.readLine());
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int D[][] = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				D[i][j] = Math.max(D[i-1][j], D[i-1][j-1]) + tri[i][j];
			}
		}
		

	}
}
