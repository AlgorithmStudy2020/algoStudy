import java.util.*;
import java.io.*;

public class Main{   
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      int[] itv = new int[n-1]; //가로수 간의 간격을 담을 배열
      int ans=0;

      int tr1 = Integer.parseInt(br.readLine());

      for(int i=0;i<n-1;i++){
        int tr2 = Integer.parseInt(br.readLine());
        itv[i] = tr2-tr1;
        tr1 = tr2;
      }

      int gcd = Math.min(itv[0],itv[1]);
      //주어진 간격들의 최대공약수

      for(int i=0;i<itv.length-1;i++){
        gcd=Math.min(gcd,itv[i+1]);
        int bal = Math.max(itv[i],itv[i+1])%gcd;
        while(bal!=0){
          //유클리드 호제법
          gcd=bal;
          bal = Math.min(itv[i],itv[i+1])%gcd;
        }
      }

      for(int i=0;i<itv.length;i++){
        ans+=itv[i]/gcd-1;
      }

      System.out.print(ans);
    }
}