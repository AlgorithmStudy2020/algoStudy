import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for(int i=0;i<c;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            int sum=0;
            for(int j=0;j<n;j++){
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }
            double avg = (double)sum/n;
            
            int stu=0;
            for(int j=0;j<n;j++){
                if(scores[j]>avg){
                    stu++;
                }
            }
            
            String ratio = String.format("%.3f%s", (double)stu/n*100,"%");
            bw.write(ratio+"\n");
        }
        bw.flush();
        bw.close();
        
    }
}