import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와BFS {
	
	public static int N, M;
	public static boolean visited[];
	public static StringBuilder sb;
	public static ArrayList adjList[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String input[] = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		adjList = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(adjList[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});
		}
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb.append(V + " ");
		dfs(V);
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
	}
	
	private static void dfs(int V) {
		
		ArrayList<Integer> list = adjList[V];
		for(Integer v : list) {
			if(visited[v]) continue;
			visited[v] = true;
			sb.append(v + " ");
			dfs(v);
		}
	}
	
	private static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[V] = true;
		q.offer(V);
		
		while(!q.isEmpty()) {
			Integer cur = q.poll();
			sb.append(cur + " ");
			
			ArrayList<Integer> list = adjList[cur];
			
			for(Integer v : list) {
				if(visited[v]) continue;
				visited[v] = true;
				q.offer(v);
			}
		}
	}
}
