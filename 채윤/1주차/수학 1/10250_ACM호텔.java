import java.util.*;
import java.io.*;

//높이 h, 각 층 방 수 w인 호텔의 n번째 손님이 묵을 방 번호
//101->201->301->...->h01->102->202->...->h02->... 순
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h,w,n;
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            w = (n-1)/h+1;
            if(n%h!=0){h= n%h;}
            
            bw.write(String.format("%d%02d\n",h,w));
        }
        
        bw.flush();
        bw.close();
        
    }
}