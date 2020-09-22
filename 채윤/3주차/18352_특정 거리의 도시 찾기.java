import java.io.*;
import java.util.*;

public class Main{
  static ArrayList<Integer>[] adj;
  static boolean[] check;
  static Queue<Integer> q;
  static int[] dst;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    q = new LinkedList<Integer>();
    

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    adj = new ArrayList[n+1];
    check = new boolean[n+1];
    dst = new int[n+1];

    for(int i=1;i<=n;i++){
      dst[i]=1000000;
    }

    for(int i=1;i<=n;i++){
      adj[i]= new ArrayList<>();
    }

    while(m>0){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      adj[u].add(v);
      
      m--;
    }
    
    dj(x);

    for(int i=1;i<=n;i++){
      if(dst[i]==k){
        sb.append(i+"\n");
      }
    }

    if(sb.length()==0){System.out.print(-1);}
    else{System.out.print(sb);}
    
    
  }

  private static void dj(int x){
    dst[x]=0;
    check[x]=true;
    q.offer(x);

    while(!q.isEmpty()){
      int num = q.poll();
      for(int y : adj[num]){
        if(!check[y]){
          check[y]=true;
          q.offer(y);
          dst[y]=Math.min(dst[y],dst[num]+1);
        }
      }
    }
  }
  
}