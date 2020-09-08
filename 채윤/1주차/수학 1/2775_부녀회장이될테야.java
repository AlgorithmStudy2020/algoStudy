import java.util.*;
import java.io.*;

//a층의 b호에는 자신의 아래(a-1)층의 1호부터 b호까지의 거주민을 합친 수 만큼 거주
//0층 각 i호에는 i명이 산다.
//k층의 n호에 사는 사람의 수 출력
public class Main{    

    private static int func(int a,int b){
      //a층 b호 거주민 수를 구하는
      //재귀함수
      int result=0;
      if(a==1){
        //1층
        for(int i=1;i<=b;i++){
          result+=i;
          //1부터 b까지 합친 수
        }
      } else {
        //1층 이상
        for(int i=1;i<=b;i++){
          result+=func(a-1,i);
          //(a-1)층의 1부터 b까지 합친 수
        }
      }
      return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while(t>0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int ans=0;
            ans = func(k,n);
            
            bw.write(ans+"\n");
            t--;
        }
        
        bw.flush();
        bw.close();
        
    }
}