import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[] var = new int[26];

        for(int i=0;i<var.length;i++){
          var[i]=-1;
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<var.length;j++){
                if(s.charAt(i)==(97+j)){
                    if(var[j]==-1){var[j]=i;}
                }
            }
        }
        for(int i : var){
            bw.write(i+" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}