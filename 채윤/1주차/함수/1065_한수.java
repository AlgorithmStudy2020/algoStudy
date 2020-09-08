import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        int count=0;
        for(int i=1;i<=n;i++){
            arr[i]=hansu(i);
        }
        for(int i=1;i<=n;i++){
            if(arr[i]){
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
    
    private static boolean hansu(int n){
        boolean result = true;
        int d = (n/10)%10 - n%10;
        n/=10;
        while(n/10!=0){
            if(d!=((n/10)%10-n%10)){
                result = false;
            }
            n/=10;
        }
        return result;
    }
}