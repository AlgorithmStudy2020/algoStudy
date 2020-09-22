import java.util.*;
import java.io.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int i=0;
      int a=0,b=0;
      int n = 0;
      int t=Integer.parseInt(br.readLine());

      while(t>0){
         n=Integer.parseInt(br.readLine());
         for(a=n/2,b=n/2;;a++,b--){
            n=a+b;
            if(check(a)&&check(b)){
               sb.append(b+" "+a);
               break;
            }
         }
         t--;
      }

      System.out.println(sb);
      
   }
   public static boolean check(int n)
   {
      
      for(int i=2;i<=n/2;i++)
      {
         if(n%i==0)
            return false;
      }
      return true;
   }
}