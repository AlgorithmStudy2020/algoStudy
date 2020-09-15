import java.util.*;
import java.io.*;

public class Main{   

  private static int F(int n){
      int result=1;
      int n0=0;
      int n1=1;
      
      for(int i=1;i<n;i++){
          result=n0+n1;
          n0=n1;
          n1=result;
      }
    return result;
  }
  
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      System.out.print(F(n));
  }
}