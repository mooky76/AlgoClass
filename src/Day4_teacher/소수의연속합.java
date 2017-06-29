package Day4_teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수의연속합 {
    static int n;
    static int prime[] = new int[4000004];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();

        n=sc.nextInt();
        //에라토스테네스의 체
        for (int i = 2; i <= n; i++) {
            if (prime[i] == 1) continue;
            //소수 vector에 담기
            v.add(i);
            for (int j = 2; i*j <= n; j++) prime[i*j] = 1;
        }
        //two-pointer
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;
        for (start = 0; start < v.size(); start++) {
            for (; end < v.size(); end++) {
                if (sum + v.get(end)>n) break;
                else {
                    sum += v.get(end);
                    if (sum == n) ans++;
                }
            }
            sum -= v.get(start);
        }
        System.out.println(ans);
    }
}