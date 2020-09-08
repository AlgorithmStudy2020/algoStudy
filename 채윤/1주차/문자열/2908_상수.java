import java.util.*;
import java.io.*;

public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a,b; //한 줄에 띄어쓰기로 구분된 두 개의 숫자
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = (a/100%10)+(a/10%10*10)+(a%10*100); //숫자를 거꾸로 읽음
        b = (b/100%10)+(b/10%10*10)+(b%10*100);
        
        if(a>b) System.out.print(a);
        
        else System.out.print(b);
        //더 큰 숫자 출력
    }
}