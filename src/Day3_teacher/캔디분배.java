package Day3_teacher;

import java.util.*;
public class 캔디분배 {
    static int R[]= new int [10000];
    static int S[] = new int [10000];
    static int T[] = new int [10000];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int K, C, t;
        t=sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            K=sc.nextInt();
            C=sc.nextInt();

            //K(-X)+CY=1
            int swap = 0;
            if (K < C) {
                swap = 1;
                int tmp = K;
                K = C;
                C = tmp;
            }
            //aS + bT = R 에서의 S,T,R(=gcd(a,b))을 구하는 방법입니다.
            R[0] = K; S[0] = 1; T[0] = 0;
            R[1] = C; S[1] = 0; T[1] = 1;
            int idx = 2;
            while (true)
            {
                int Q = R[idx - 2] / R[idx - 1];
                R[idx] = R[idx - 2] - R[idx - 1] * Q;
                S[idx] = S[idx - 2] - S[idx - 1] * Q;
                T[idx] = T[idx - 2] - T[idx - 1] * Q;
                if (R[idx] == 0) { //만약 나머지가 0 이라면, 이전(idx-1) S,T,R이 우리가 구하고자 하는 값이 됩니다.
                    idx--;
                    break;
                }
                idx++;
            }
            //최대공약수가 1보다 크다면 1을 만드는건 불가능
            if (R[idx] > 1) System.out.println("IMPOSSIBLE");
            else {
                //최초 K와 C의 값 교체가 일어났다면 원상복구
                if (swap == 1) {
                    int tmp = K;
                    K = C;
                    C = tmp;
                    tmp = S[idx];
                    S[idx] = T[idx];
                    T[idx] = tmp;
                }
                // KX+1=CY <=> K(-X)+CY=1 이기 때문에, -X<0, Y>0 을 만족해야함
                while (S[idx] >= 0) { // -X>=0 이라면 <0으로 증가
                    S[idx] -= (C / R[idx]);
                    T[idx] += (K / R[idx]);
                }
                while (T[idx] <= 0) { // T<=0 이라면 >0 으로 증가
                    T[idx] += (K / R[idx]);
                    S[idx] -= (C / R[idx]);
                }
                // 최종 -S<0 이거나 T<=0, 또는 사탕을 살 수 있는 개수가 최대 10억개라고 했는데 이를 초과했다면 불가능
                if (S[idx]>=0 || T[idx]<=0 || T[idx]>1000000000) System.out.println("IMPOSSIBLE\n");
                else System.out.println(T[idx]);
            }
        }
    }
}
