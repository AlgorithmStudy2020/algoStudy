import java.io.*;
import java.util.*;

public class Main{
  static ArrayList<Integer>[] adj;
  static boolean[] check;
  static StringBuilder sb;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    adj = new ArrayList[n+1];
    check = new boolean[n+1];

    for(int i=1;i<=n;i++){
      adj[i]= new ArrayList<>();
    }

    while(m>0){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      adj[u].add(v);
      adj[v].add(u);
      
      m--;
    }
    
    for(int i=1;i<=n;i++){
      Collections.sort(adj[i]);
    }

    dfs(s);
    sb.append("\n");

    check = new boolean[n+1];
    bfs(s);
    sb.append("\n");

    System.out.print(sb);
    
  }

  private static void dfs(int x){
    if(check[x]){return;}
    
    check[x]=true;
    sb.append(x+" ");
    for(int y : adj[x]){
      if(!check[y]){
        dfs(y);
      }
    }
  }

  private static void bfs(int x){
    if(check[x]){return;}

    Queue<Integer> q = new LinkedList<>();
    q.offer(x);
    check[x]=true;

    while(!q.isEmpty()){
      int num = q.poll();
      sb.append(num+" ");
      for(int y : adj[num]){
        if(!check[y]){
          check[y]=true;
          q.offer(y);
      }
    }
    
    }
  }

}