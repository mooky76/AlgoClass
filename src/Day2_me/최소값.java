package Day2_me;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소값 {

	static long tree[] = new long[4 * 100000 + 10];

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
			tree[sz + i] = Integer.parseInt(br.readLine());
		}

		// ������ �κ� �ִ밪���� ä���
		for (int i = sz * 2 + 1; i > sz + N; i--) {
			tree[i] = 1000000000;
		}

		// ��� Ʈ�� �ּҰ����� ä���
		for (int i = sz; i >= 1; i--) {
			if (tree[i * 2] >= tree[i * 2 + 1]) {
				tree[i] = tree[i * 2 + 1];
			} else {
				tree[i] = tree[i * 2];
			}
		}

		long min;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			left += sz;
			right += sz;

			min = 1000000000;
			
			while (left <= right) {
				if (left % 2 == 1 && min > tree[left]) {
					min = tree[left];
				}

				if (right % 2 == 0 && min > tree[right]) {
					min = tree[right];
				}

				left = (left + 1) / 2;
				right = (right - 1) / 2;
			}

			System.out.println(min);
		}
	}
}
