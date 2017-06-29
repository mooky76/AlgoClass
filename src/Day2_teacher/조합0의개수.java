package Day2_teacher;

import java.util.*;

public class 조합0의개수 {

    public static int f5(int n) {
        int ret = 0;
        while (n>0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
    public static int f2(int n) {
        int ret = 0;
        while (n>0) {
            ret += n / 2;
            n /= 2;
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f,t;
        int a=sc.nextInt();
        int b=sc.nextInt();
        f = f5(a) - f5(a - b) - f5(b);
        t = f2(a) - f2(a - b) - f2(b);
        if(t<f) System.out.println(t);
        else System.out.println(f);
    }
}