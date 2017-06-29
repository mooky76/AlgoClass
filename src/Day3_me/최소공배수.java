package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int x = a;
		int y = b;
		int r = x%y;
		
		while (r > 0) {
			x = y;
			y = r;
			r = x%y;
		}
		
		System.out.println(y);
		System.out.println(a*b/y);
		
	}
}
