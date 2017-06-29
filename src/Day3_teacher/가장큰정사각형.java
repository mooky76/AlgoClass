package Day3_teacher;

import java.util.Scanner;

public class 가장큰정사각형 {
    static int n, m, ans;
    static char C[][] = new char[1004][1004];
    static int D[][] = new int[1004][1004];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        for (int i = 1 ; i <= n; i++) {
            String str=sc.next();
            for(int j=1;j<=m;j++){
                C[i][j]=str.charAt(j-1);
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(C[i][j]=='0') D[i][j]=0;
                else{
                    D[i][j]=Math.min(D[i-1][j], Math.min(D[i-1][j-1], D[i][j-1]))+1;
                }
                if(ans<D[i][j]) ans=D[i][j];
            }
        }
        System.out.println(ans*ans);
    }
}