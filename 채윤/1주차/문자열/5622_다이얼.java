import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans=0;
        int[] time = new int[26];
        for(int i=0;i<26;i++){
            time[i]=i/3*1+3;
        }
        
        int ch = br.read();
        while(ch>64){
            ans += time[ch-65];
            ch = br.read();
        }
        System.out.print(ans);
    }
}