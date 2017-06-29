package Day1_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arrayN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrayN[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrayN);
		
		int M = Integer.parseInt(br.readLine());
		int[] arrayM = new int[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrayM[i] = Integer.parseInt(st2.nextToken());
		}
		
		int result;
		for (int i = 0; i < arrayM.length; i++) {
			result = 0;
			int low = 0;
			int hi = N-1;
			int mid;
			
			while (low <= hi) {
				mid = (low + hi) / 2;
				
				if (arrayN[mid] == arrayM[i]) {
					result = 1;
					break;
				}else{
					if (arrayN[mid] > arrayM[i]) {
						hi = mid - 1;
					}else{
						low = mid + 1;
					}
				}
			}
			System.out.println(result);
			
		}
	}
}
