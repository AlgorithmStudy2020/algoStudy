import java.util.*;
import java.io.*;

public class Main{

    private static boolean[] SoE(int n){
      //에라토스테네스의 체

      boolean[] isPrimeNum = new boolean[n+1];

      isPrimeNum[1]=true; 
      //1은 소수가 아님

      for(int i=2;i<Math.sqrt(n);i++){

        if(isPrimeNum[i]){
          continue;
          //i가 소수가 아니면 건너뜀
        }else{
          for(int j=i*i;j<=n;j+=i){
            isPrimeNum[j]=true;
          }
        }
      }

      return isPrimeNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        boolean[] arr = SoE(n);

        for(int i=m;i<=n;i++){
          if(!arr[i]){bw.write(i+"\n");}
        }
        bw.flush();
        bw.close();
    }
}