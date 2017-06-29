package Day1_teacher;

import java.util.*;

public class 수찾기 {
    static int n, m, a,low,hi,mid;
    static int A[] = new int[100000+10];
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        for (int i = 1; i <= n; i++)A[i]=sc.nextInt();
        Arrays.sort(A,1,n+1);
        m=sc.nextInt();
        for (int i = 1; i <= m; i++) {
            a=sc.nextInt();
            int ans=0;
            if (a < A[1] || a>A[n]) System.out.println(0);
            else {
                low = 1;
                hi = n;
                while (low <= hi) {
                    mid = (low + hi) / 2;
                    if (a < A[mid]) hi = mid - 1;
                    else if (a == A[mid]) {
                        ans=1;
                        break;
                    }
                    else low = mid + 1;
                }
                System.out.println(ans);
            }
        }
    }
}