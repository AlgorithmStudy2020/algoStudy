#include<iostream>
#include<vector>
#include<queue>
#include<memory.h>
#define NMAX 300001
using namespace std;

int N, M, K, X; //도시 개수 N,도로 개수 M, 거리정보 K, 출발도시 X
vector<vector<int>> graph(NMAX);
int dist[NMAX];
void init() {
	cin >> N >> M >> K >> X;

	for (int i = 0; i < M; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;
		graph[temp1].push_back(temp2);
	}
}

void bfs(int x) {
	memset(dist, -1, sizeof(dist));
	queue<pair<int,int>> q;

	//시작점
	q.push({ x,0 });
	dist[x] = 0;

	while (!q.empty()) {
		int cur = q.front().first;
		int dis = q.front().second;

		q.pop();

		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur][i];
			if (dist[next]!=-1) continue;
			dist[next] = dis+1;

			q.push({ next,dis + 1 });
		}
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	init();
	bfs(X);

	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		if (dist[i] == K) {
			cout << i << endl;
			cnt++;
		}
	}
	if (cnt == 0) cout << "-1";
}