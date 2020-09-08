import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = y-x;

            //d 123456789...
            //n 1233445556667777888899999
            //i 1 2   3     4       5
            
            int i=0;
            while(d>0){
              i++;
              d-=2*i;
            }

            if(d*(-1)<i){bw.write(i*2+"\n");}
            else{bw.write((i*2-1)+"\n");}
            t--;
        }
        bw.flush();
        bw.close();
    }
}