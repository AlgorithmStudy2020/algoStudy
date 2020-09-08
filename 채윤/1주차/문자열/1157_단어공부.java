import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        int ch = br.read();

        while(ch>64){
          if(ch>96){ch-=32;}
          count[ch-65]++;
          ch = br.read(); //한 글자씩 읽어와서 카운트
        }

        int max=count[0];
        int index=0;
        int ans=0;

        for(int i=1;i<count.length;i++){
          if(count[i]>max){
            max = count[i];
            index = ans = i;
          } else if(count[i]==max){
            ans = -2; //'?' 아스키 코드 63
          }
        }

        System.out.print((char)(ans+65)+"\n");
    }
}