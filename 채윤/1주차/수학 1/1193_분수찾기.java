import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int i =1;\
        
        //  n -> 출력
        // ~1 -> 1/1
        // ~3 -> 1/2,2/1
        // ~6 -> 3/1,2/2,1/3
        //~10 -> 1/4,2/3,3/2,4/1
        // ...

        while(sum<n){
            i++;
            sum+=i;
        }
        
        if(i%2==0){
          bw.write((i-sum+n)+"/"+(sum-n+1)+"\n");
        }else{
          bw.write((sum-n+1)+"/"+(i-sum+n)+"\n");
        }
        
        bw.flush();
        bw.close();
        
    }
}