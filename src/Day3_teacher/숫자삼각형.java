package Day3_teacher;

import java.util.Scanner;

public class 숫자삼각형 {
    static int n;
    static int C[][] = new int[600][600];
    static int D[][] = new int[600][600];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

            n=sc.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    C[i][j]=sc.nextInt();
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    if (D[i - 1][j] > D[i - 1][j - 1]) D[i][j] = D[i - 1][j] + C[i][j];
                    else D[i][j] = D[i - 1][j - 1] + C[i][j];
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (D[n][i] > ans) ans=D[n][i];
            }
            System.out.println(ans);
    }
}
