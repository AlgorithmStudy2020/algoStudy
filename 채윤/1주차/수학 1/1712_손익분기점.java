import java.util.*;
import java.io.*;

// TC = A만원 고정 비용 + (B만원 가변 비용*노트북 수)
// TR = 노트북 가격 C만원*노트북 수
// TR>TC가 되는 가장 작은 정수 n

//a+b*n = c*n
//a = (c-b)*n
// n = a/(c-b)
public class Main{    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a,b,c;
        double sal = 0;
        int bep;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if(b>=c){
          bep = -1;
        } else{
          sal = (double)a/(c-b);
          bep = (int)sal+1;
        }
        System.out.print(bep);
    }
}