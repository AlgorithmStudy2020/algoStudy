import java.util.*;
import java.io.*;

public class Main{   
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      int[][] cost = new int[n][3];

     for(int i=0;i<n;i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        cost[i][0] = Integer.parseInt(st.nextToken());
        cost[i][1] = Integer.parseInt(st.nextToken());
        cost[i][2] = Integer.parseInt(st.nextToken());
      }

      int sum[][] = new int[n][3];

      sum[0][0]=cost[0][0];
      sum[0][1]=cost[0][1];
      sum[0][2]=cost[0][2];

      for(int i=1;i<n;i++){
        sum[i][0]=Math.min(sum[i-1][1],sum[i-1][2])+cost[i][0];
        sum[i][1]=Math.min(sum[i-1][0],sum[i-1][2])+cost[i][1];
        sum[i][2]=Math.min(sum[i-1][0],sum[i-1][1])+cost[i][2];
      }

      int ans = Math.min(Math.min(sum[n-1][0],sum[n-1][1]),sum[n-1][2]);

      bw.write(ans+"\n");
      bw.flush();
      bw.close();
  }
}