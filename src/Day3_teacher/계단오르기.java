package Day3_teacher;

import java.util.*;
public class 계단오르기 {
    static int C[]= new int [10004];
    static int D[][] = new int [10004][2];
    public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int N=sc.nextInt();
            for (int i = 1; i <= N; i++) C[i]=sc.nextInt();
            D[1][0] = C[1];
            D[1][1] = C[1];
            for (int i = 2; i <= N; i++) {
                if(D[i-2][0]>D[i-2][1]) D[i][1]=D[i-2][0]+C[i];
                else D[i][1]=D[i-2][1]+C[i];
                D[i][0] = D[i - 1][1] + C[i];
            }
            if(D[N][0]>D[N][1]) System.out.println(D[N][0]);
            else System.out.println(D[N][1]);
    }
}