package Day3_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수합 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A[] = new int[2];
		int B[] = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		A[0] = Integer.parseInt(st.nextToken());
		A[1] = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		B[0] = Integer.parseInt(st2.nextToken());
		B[1] = Integer.parseInt(st2.nextToken());
		
		int top = A[0]*B[1] + B[0]*A[1];
		int bottom = A[1]*B[1];

		int x = top;
		int y = bottom;
		int r = x % y;

		while (r > 0) {
			x = y;
			y = r;
			r = x % y;
		}
		
		System.out.println(top/y+" "+bottom/y);

	}

}
