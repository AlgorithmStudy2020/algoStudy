import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        float nmean = (float)sum*100/(arr[n-1]*n);
        bw.write(nmean+"\n");
        bw.flush();
        bw.close();
    }
}