package Day2_teacher;

import java.util.*;

public class 사전 {
    static int a, b, c,n;
    public static long combi(long n, long r) {
        if (r == 0 || n == r) return 1;
        if (r > n / 2) r = n - r;
        long ret=1;
        for (long i = 1; i <= r; i++) {
            ret *= n-i+1;
            ret /= i;
            if (ret >= c) return c;
        }
        return ret;
    }
    static char ans[] = new char[210];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        int low,mid,hi,cand,s,r;
            n = a + b;
            if (combi(a + b, a) < c) System.out.println(-1);
            else {
                low = 1; 
                hi = n-b+1; //전체 문자의 개수-z문자의 개수+1 (a문자의 개수+1)
                s = 1; //이전 z의 위치+1
                while (c>1) {
                    cand = hi;
                    while (low <= hi) {
                        mid = (low + hi)/2;
                        if (combi(n - mid, b) < c) {
                            cand = mid; //z의 위치는 mid이거나 mid보다 왼쪽이므로
                            hi = mid - 1;
                        }
                        else low = mid + 1;
                    }
                    for (int i = s; i < cand; i++) ans[i] = 'a';
                    ans[cand] = 'z';
                    s = cand + 1;
                    c -= combi(n-cand, b); //지나간 문자의 개수를 빼줌
                    b--;//z를 하나 사용했으므로 1 감소
                    low = cand + 1; //현재 z위치 다음
                    hi = n - b+1;
                }
                for (int i = s; i < hi; i++) ans[i] = 'a';
                for (int i = hi; i <= n; i++) ans[i] = 'z';
                for(int i=1;i<=n;i++) System.out.print(ans[i]);
            }
    }

}