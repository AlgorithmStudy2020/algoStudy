import java.util.*;
import java.io.*;

public class Main{
    
    private static int d(int n){
        int result=n;
        while(n!=0){
            result += n%10;
            n/=10;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[10001];
        for(int i=1;i<10000;i++){
            if(d(i)<=10000){
                arr[d(i)]=true;
            }
        }
        for(int i=1;i<=10000;i++){
            if(!arr[i]){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}