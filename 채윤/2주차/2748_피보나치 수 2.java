import java.util.*;
import java.io.*;

public class Main{   

  private static long F(int n){
    long[] memo = new long[n+1];
    memo[0]=0;
    memo[1]=1;

    for(int i=2;i<=n;i++){
      memo[i]=memo[i-2]+memo[i-1];
    }

    return memo[n];
  }
  
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      System.out.print(F(n));
  }
}