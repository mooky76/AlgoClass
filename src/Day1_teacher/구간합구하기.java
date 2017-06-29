package Day1_teacher;

import java.io.*;
import java.util.*;

public class 구간합구하기 {
    //indexed tree의 사이즈 = N*4
    static long tree[] = new long[4*1000000+10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();
        int sz=1; // 트리 상단의 크기
        for(sz=1;sz<=N;sz*=2);
        sz--;
        // N개의 값을 트리 최하단에 입력
        for(int i=1;i<=N;i++){
            tree[i+sz] = sc.nextLong();
        }
        // 트리 상단 업데이트
        for(int i=sz;i>=1;i--){
            //부모의 값 = 왼쪽자식의 값 + 오른쪽 자식의 값
            tree[i]=tree[i*2]+tree[i*2+1];
        }
        //쿼리 입력
        for(int i=1;i<=M+K;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            // b위치의 수를 c로 변경
            if(a==1){
                //수열에서 b위치는 트리에서 sz+b의 위치
                //변경할 값과 기존값의 차이만큼을 더함으로 업데이트처리
                long diff=(long)c-tree[sz+b];
                // idx : sz+b 부터 부모노드로 이동할 인덱스
                int idx=sz+b;
                while(idx>=1){
                    //값 업데이트
                    tree[idx]+=diff;
                    //부모노드로 이동
                    idx/=2;
                }
            }
            // b~c의 구간합
            else{
                //좌측구간
                int left=sz+b;
                //우측구간
                int right=sz+c;
                //합
                long Ans=0;
                while(left<=right){
                    //좌측구간이 작은 트리의 우측에 있을 때 계산
                    if(left%2==1) Ans+=tree[left];
                    //우측구간이 작은 트리의 좌측에 있을 때 계산
                    if(right%2==0) Ans+=tree[right];
                    //좌측구간을 한칸 오른쪽으로 이동
                    left=left+1;
                    //좌측구간을 위로 이동
                    left=left/2;
                    //우측 구간을 한칸 왼쪽으로 이동
                    right=right-1;
                    //우측 구간을 위로 이동
                    right=right/2;
                }
                System.out.println(Ans);
            }
        }
    }
}