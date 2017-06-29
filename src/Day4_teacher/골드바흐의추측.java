package Day4_teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class 골드바흐의추측 {
    static int n, k;
    static int p[] = new int[1000004];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();
            //에라토스테네스의 체
            for (int i = 2; i <= 1000000; i++) {
                if (p[i]==1) continue;
                //소수를 모두 list에 push
                v.add(i);
                for (int j = 2; i*j <= 1000000; j++) p[i*j] = 1;
            }
            int n;
            while (true) {
                n=sc.nextInt();
                if (n==0) break;
                for (int i=0;i<v.size();i++) {
                    int it=v.get(i);
                    // list의 원소 it는 소수인걸 알고 있으니, n-it가 소수가 되는순간 it와 n-it가 둘 다 소수가 된다.
                    if (p[n - it]==0)   {
                        System.out.println(n+" = "+it+" + "+(n-it));
                        break;
                    }
            }
        }
    }
}