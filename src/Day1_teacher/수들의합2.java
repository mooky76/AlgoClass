package Day1_teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수들의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int arr[] = new int[N+1];
        for(int i=1;i<=N;i++) arr[i]=sc.nextInt();
        int s=1; // 시작점
        int e=1; // 끝점
        int sum=0;
        int ans=0;
        for(s=1;s<=N;s++){
            for(;e<=N;e++){
                //다음 수를 더했을 때 합이 M보다 크면 정지
                if(sum+arr[e]>M) break; 
                //다음 수를 더했을 때 합이 M보다 작거나 같다면 끝점을 증가
                else{
                    sum+=arr[e];
                    if(sum==M) ans++;
                }
            }
            sum-=arr[s];
        }
        System.out.println(ans);
    }
}