import java.util.*;
import java.io.*;

public class Main{
    
    private static int getScore(String s){
        int score=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='O'){
                score++;
            } else {
                score=0;
            }
            result += score;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            bw.write(getScore(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
        
    }
}