import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum=0;
        for(int i=0;i<n;i++){
            //sum += s.charAt(i)-'0';
            sum += Character.getNumericValue(s.charAt(i));
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}