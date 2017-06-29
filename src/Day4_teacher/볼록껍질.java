package Day4_teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 볼록껍질 {
    static int n,p_x,p_y;
    static int xy[][] = new int[100010][2];
    static int stk[] = new int[100010];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        // 각도정렬의 기준점 (p_x, p_y), 최하단 좌표들중 가장 좌측에 있는 점
        p_x=50000;
        p_y=50000;
        for(int i=1;i<=n;i++){
            xy[i][0]=sc.nextInt();
            xy[i][1]=sc.nextInt();
            if(xy[i][1]<p_y) {
                p_x=xy[i][0];
                p_y=xy[i][1];
            }
            else if(xy[i][1]==p_y && xy[i][0]<p_x) p_x=xy[i][0];
        }
        // 각도정렬
        Arrays.sort(xy,1,n+1,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                long ret=ccw(p_x,p_y,o1[0],o1[1],o2[0],o2[1]);
                if(ret>0) return -1;
                else if(ret==0 && d(p_x,p_y,o1[0],o1[1])<d(p_x,p_y,o2[0],o2[1])) return -1;
                else return 1;
            }
        });
        // e : 스택의 size
        int e=0;
        xy[n+1][0]=xy[1][0];
        xy[n+1][1]=xy[1][1];
        for(int i=1;i<=n;i++){
        //스택의 사이즈가 2 이상이고, 스택의 마지막 두 점과 다음점의 ccw값이 0보다 작거나 같으면, 스택의 마지막 원소를 제거
            while(e>=2 && ccw(xy[stk[e-2]][0],xy[stk[e-2]][1],xy[stk[e-1]][0],xy[stk[e-1]][1],xy[i][0],xy[i][1])<=0){
                e--;
            }
            //다음점을 스택에 추가
            stk[e]=i;
            e++;
        }
        System.out.println(e);
    }
    public static long ccw(long x1,long y1,long x2, long y2, long x3, long y3){
        long ret=(x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
        if(ret>0) return 1;
        else if(ret==0) return 0;
        else return -1;
    }
    public static long d(long x1, long y1, long x2, long y2){
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }
}
