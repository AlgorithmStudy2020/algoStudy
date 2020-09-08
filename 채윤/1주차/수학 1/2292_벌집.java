import java.util.*;
import java.io.*;


public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //  n -> 출력
        // ~1 -> 1
        // ~7 -> 2
        //~19 -> 3
        //~37 -> 4
        //~61 -> 5
        //...
        
        int sum=1;
        int i=1;
        while(sum<n){
            sum += 6*i;
            i++;
        }
        System.out.print(i);
        
    }
}