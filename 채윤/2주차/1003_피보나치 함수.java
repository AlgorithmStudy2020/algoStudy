import java.util.*;
import java.io.*;

public class Main{   

  private static int[] FF(int n){
    int[] arr = new int[2];
    int[] arr0 = new int[2];
    arr0[0]=1;
    int[] arr1 = new int[2];
    arr1[1]=1;

    for(int j=2;j<=n;j++){
      for(int i=0;i<=1;i++){
        arr[i] = arr0[i]+arr1[i];
      }
      arr0 = arr1.clone();
      arr1 = arr.clone();
    }

    if(n==0){return arr0;}
    else if(n==1){return arr1;}
    else{return arr1;}

  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int t = Integer.parseInt(br.readLine());
      while(t>0){
        int n = Integer.parseInt(br.readLine());
        int[] arr = FF(n);

        bw.write(arr[0]+" "+arr[1]+"\n");
        t--;
      }
      bw.flush();
      bw.close();
  }
}