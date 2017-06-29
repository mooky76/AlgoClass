package Day4_teacher;

import java.util.Scanner;

public class 에라토스테네스의체 {
    static int n, k;
    static int prime[] = new int[1004];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            // 소수가 아니면 지나간다
            if (prime[i] == 1)continue;
            // 소수라면 순서대로 n보다 작거나 같을 때 까지 체크
            for (int j = 1; i * j <= n; j++) {
                //이미 체크된 곳이라면 지나간다.
                if (prime[i * j]==1) continue;
                prime[i * j] = 1;
                k--;
                if (k==0) {
                    System.out.println(i*j);
                    return;
                }
            }
        }
    }
}