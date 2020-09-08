import java.util.*;
import java.io.*;

// 3a*5b = N
// (a+b)가 최소가 되는 정수 a,b
// 나눠 떨어지지 않으면 -1
// (a+b)를 구하기
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int b = n/5;
        int ans=-1;
        while(b>=0){
            double a = (double)(n-5*b)/3;
            if(a%1==0){
                ans=(int)a+b;
                break;
            }
            b--;
        }
        System.out.print(ans);
    }
}