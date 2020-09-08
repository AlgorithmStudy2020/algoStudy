import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean flag;
        int sum=0;

        for(int j=n;j>=m;j--){
          flag=true;

          if(j==1){continue;}

          for(int i=2;i<j;i++){
            if(j%i==0){
              flag=false;
              break;
            }
          }
          if(flag){sum+=j; n=j;}
        }
        
        if(sum==0){bw.write(-1+"\n");}
        else{bw.write(sum+"\n"+n+"\n");}
        bw.flush();
        bw.close();
    }
}