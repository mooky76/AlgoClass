package Day2_teacher;

import java.io.*;
import java.util.*;

public class 최소값과최대값 {
    //indexed tree의 사이즈 = N*4
    static long min_tree[] = new long[4*1000000+10];
    static long max_tree[] = new long[4*1000000+10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int sz=1; // 트리 상단의 크기
        for(sz=1;sz<=N;sz*=2);
        sz--;
        // N개의 값을 트리 최하단에 입력
        for(int i=1;i<=N;i++){
            max_tree[i+sz] = min_tree[i+sz] = sc.nextLong();
        }
        for(int i=sz+N+1;i<=sz*2+1;i++) min_tree[i]=1987654321;
        for(int i=sz+N+1;i<=sz*2+1;i++) max_tree[i]=-1;
        // min트리 상단 업데이트
        for(int i=sz;i>=1;i--){
            //부모의 값 = 왼쪽자식의 값, 오른쪽 자식의 값 중 작은 것
            if(min_tree[i*2]<min_tree[i*2+1]) min_tree[i]=min_tree[i*2];
            else min_tree[i]=min_tree[i*2+1];
        }
        // max트리 상단 업데이트
        for(int i=sz;i>=1;i--){
            //부모의 값 = 왼쪽자식의 값, 오른쪽 자식의 값 중 큰 것
            if(max_tree[i*2]>max_tree[i*2+1]) max_tree[i]=max_tree[i*2];
            else max_tree[i]=max_tree[i*2+1];
        }
        //쿼리 입력
        for(int i=1;i<=M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long min_ans=1987654321;
            long max_ans=-1;
            // a~b사이의 최소값 찾기
            //좌측구간
            int left=sz+a;
            //우측구간
            int right=sz+b;
            while(left<=right){
                //좌측구간이 작은 트리의 우측에 있을 때 계산
                if(left%2==1) {
                    if(min_ans>min_tree[left]) min_ans=min_tree[left];
                }
                //우측구간이 작은 트리의 좌측에 있을 때 계산
                if(right%2==0){
                    if(min_ans>min_tree[right]) min_ans=min_tree[right];
                }
                //좌측구간을 한칸 오른쪽으로 이동
                left=left+1;
                //좌측구간을 위로 이동
                left=left/2;
                //우측 구간을 한칸 왼쪽으로 이동
                right=right-1;
                //우측 구간을 위로 이동
                right=right/2;
            }
            // a~b사이의 최대값 찾기
            //좌측구간
            left=sz+a;
            //우측구간
            right=sz+b;
            while(left<=right){
                //좌측구간이 작은 트리의 우측에 있을 때 계산
                if(left%2==1) {
                    if(max_ans<max_tree[left]) max_ans=max_tree[left];
                }
                //우측구간이 작은 트리의 좌측에 있을 때 계산
                if(right%2==0){
                    if(max_ans<max_tree[right]) max_ans=max_tree[right];
                }
                //좌측구간을 한칸 오른쪽으로 이동
                left=left+1;
                //좌측구간을 위로 이동
                left=left/2;
                //우측 구간을 한칸 왼쪽으로 이동
                right=right-1;
                //우측 구간을 위로 이동
                right=right/2;
            }
            System.out.println(min_ans+" "+max_ans);
        }
    }
}