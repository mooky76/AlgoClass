package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소값과최대값 {

	static long MinTree[] = new long[4 * 100000 + 10];
	static long MaxTree[] = new long[4 * 100000 + 10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int sz = 1;
		for (sz = 1; sz <= N; sz *= 2)
			;
		sz--;

		// N�� ���� Ʈ�� ���ϴܿ� �Է�
		for (int i = 1; i <= N; i++) {
			int imsi = Integer.parseInt(br.readLine());
			
			MinTree[sz + i] = imsi;
			MaxTree[sz + i] = imsi;
		}

		// ������ �κ� �ִ밪���� ä���
		for (int i = sz * 2 + 1; i > sz + N; i--) {
			MinTree[i] = 1000000000;
			MaxTree[i] = 0;
			
		}

		// ��� Ʈ�� �ּҰ�, �ִ밪 ä���
		for (int i = sz; i >= 1; i--) {
			if (MinTree[i * 2] >= MinTree[i * 2 + 1]) {
				MinTree[i] = MinTree[i * 2 + 1];
			} else {
				MinTree[i] = MinTree[i * 2];
			}
			
			if (MaxTree[i*2] >= MaxTree[i*2+1]) {
				MaxTree[i] = MaxTree[i*2];
			}else{
				MaxTree[i] = MaxTree[i*2+1];
			}
		}

		long min;
		long max;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// �ּҰ� ���ϴ� �κ�
			int left = a + sz;
			int right = b + sz;

			min = 1000000000;
			
			while (left <= right) {
				if (left % 2 == 1 && min > MinTree[left]) {
					min = MinTree[left];
				}

				if (right % 2 == 0 && min > MinTree[right]) {
					min = MinTree[right];
				}

				left = (left + 1) / 2;
				right = (right - 1) / 2;
			}
			
			// �ִ밪 ���ϴ� �κ�
			left = a + sz;
			right = b + sz;

			max = 0;
			
			while (left <= right) {
				if (left % 2 == 1 && max < MaxTree[left]) {
					max = MaxTree[left];
				}

				if (right % 2 == 0 && max < MaxTree[right]) {
					max = MaxTree[right];
				}

				left = (left + 1) / 2;
				right = (right - 1) / 2;
			}

			System.out.println(min+" "+max);
		}
	}
}

