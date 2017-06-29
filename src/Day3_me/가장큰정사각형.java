package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int square[][] = new int[N+1][M+1];
		String str;
		for (int i = 1; i <= N; i++) {
			str = br.readLine();
			for (int j = 1; j <= M; j++) {
				square[i][j] = str.charAt(j-1) - 48;
			}
		}
		
		int D[][] = new int[N+1][M+1];
		int lineMax = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (square[i][j] == 0) {
					D[i][j] = 0;
				}else{
					D[i][j] = Math.min(Math.min(D[i][j-1], D[i-1][j]), D[i-1][j-1]) + 1;
				}
				if(D[i][j] > lineMax) lineMax = D[i][j];
			}
		}
		
		System.out.println(lineMax * lineMax);
		
	}
}
