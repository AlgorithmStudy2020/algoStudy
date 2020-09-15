import java.util.*;
import java.io.*;

public class Main{   
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      int[] req = new int[n]; //n개의 지방 예산 요청
      int left=0;
      int right=0;
      int mid=0;
      

      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0;i<n;i++){
        req[i] = Integer.parseInt(st.nextToken());
        right = Math.max(right,req[i]);
      }

      int m = Integer.parseInt(br.readLine()); //총 국가예산

      while(left <= right){
        //이분탐색으로 상한액 탐색
        mid = (left+right)/2;
        int sum=0;

        for(int i=0;i<n;i++){
          sum+=Math.min(req[i],mid);
        }
        
        if(sum<=m){
          //총 예산이 국가 예산보다 적으면 오른쪽 탐색
          left = mid+1;
        } else if(sum>m){
          //총 예산이 국가 예산보다 크면 왼쪽 탐색
          right = mid-1;
        }
      }

      System.out.print((left+right)/2);

    }
}