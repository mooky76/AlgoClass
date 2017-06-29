package Day3_teacher;

import java.util.*;
public class 최대공약수와최소공배수 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if (a < b) {
            //b ^= a; a ^= b; b ^= a;
            int tmp=a;
            a=b;
            b=tmp;
        }
        int x = a;
        int y = b;
        int r = x%y;
        while (r>0) {
            x = y;
            y = r;
            r = x%y;
        }
        int ans=a/y*b;
        System.out.println(y);
        System.out.println(ans);
    }
}
