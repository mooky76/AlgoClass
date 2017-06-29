package Day1_teacher;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시간초과 {
    static long C,N,T,L,Result,Time;
    static String S;
    static String Ans;
    static int MaxIdx;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine().trim());
        for(int test_case = 1; test_case <= C; test_case++){
            String[] st = br.readLine().trim().split(" ");
            S = st[0];
            N = Long.parseLong(st[1]);
            T = Long.parseLong(st[2]);
            L = Long.parseLong(st[3]);
            Ans = "May Pass.";
            Time = L* 100000000L;

            if( S.equals("O(N)")){
                Result = N*T;
                if(Time < Result || Result<0){
                    Ans = "TLE!";
                    break;
                }
            } 
            else if( S.equals("O(N^2)")){
                Result = T;
                for(int i = 1 ; i <= 2 ; i++){
                    Result = Result * N;
                    if(Time < Result|| Result<0){
                        Ans = "TLE!";
                        break;
                    }
                }

            }  
            else if( S.equals("O(N^3)")){
                Result = T;
                for(int i = 1 ; i <= 3 ; i++){
                    Result = Result * N;
                    if(Time < Result|| Result<0){
                        Ans = "TLE!";
                        break;
                    }

                }
            }  
            else if( S.equals("O(2^N)")){
                Result = T;
                for(int i = 1 ; i <= N ; i++){
                    Result = Result * 2;
                    if(Time < Result|| Result<0){
                        Ans = "TLE!";
                        break;
                    }
                }
            }  
            else if( S.equals("O(N!)")){         
                Result = T;
                for(int i = 1 ; i <= N ; i++){
                    Result = Result * i;
                    if(Time < Result|| Result<0){
                        Ans = "TLE!";
                        break;
                    }
                }
            }

            System.out.println(Ans);

        }

    }

}