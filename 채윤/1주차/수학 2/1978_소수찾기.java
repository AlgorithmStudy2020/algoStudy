import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = t;

        while(t>0){
          int x = Integer.parseInt(st.nextToken());
          if(x==1){ans--;}

          int n=2;
          while(n<x){
            if(x%n==0){
              ans--;
              break;
            }
            n++;
          }

          t--;
        }

        System.out.print(ans);
    }
}