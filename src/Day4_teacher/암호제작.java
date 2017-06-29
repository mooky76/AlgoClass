package Day4_teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class 암호제작 {

    static char P[] = new char[104];
    static int k;
    static int prime[] = new int[1000004];
    static ArrayList<Integer>v = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        k=sc.nextInt();
        //에라토스테네스의 체
        for (int i = 2; i <= k; i++) {
            if (prime[i]==1) continue;
            v.add(i);
            for (int j = 2; i*j <= k; j++) prime[i*j] = 1;
        }
        for (int j=0;j<v.size();j++) {
            int it=v.get(j);
            long ans = 0;
            for (int i = 0; i < str.length(); i++) {
                long x = 10;
                int p = str.length() - i - 1;
                long cand = str.charAt(i)-'0';
                while (p>0) {
                    if (p %2==1) {
                        cand *= x;
                        cand %= it;
                    }
                    x *= x;
                    x %= it;
                    p /= 2;
                }
                ans += cand;
                ans %= it;
            }
            if (ans==0) {
                System.out.println("BAD "+it);
                return;
            }
        }
        System.out.println("GOOD");
    }

}