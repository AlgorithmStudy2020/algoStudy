#define _CRT_SECURE_NO_WARNINGS
#include<cstdio>
#include<cstring>
#include<queue>
#include<algorithm>
using namespace std;
//다리의 양 끝은 섬과 인접한 바다 위에 있어야 하고, 
//한 다리의 방향이 중간에 바뀌면 안된다. 또, 다리의 길이는 2 이상이어야 한다.
struct P {
	int first, second;
};
class Node {
public:
	int node[2];
	int val;
	Node(int f, int s, int v) {
		this->node[0] = f;
		this->node[1] = s;
		this->val = v;
	}
	bool operator <(const Node nd) const{
		return this->val < nd.val;
	}
};
int N, M;
int map[10][10];
int d[10][10];
int dx[] = { 0,0,1,-1 }, dy[] = { 1,-1,0,0 };
int geri[12][12];
int parent[12];
void bfs(int x, int y, int val) {
	queue<P> q;
	q.push({ x, y });
	d[x][y] = val;
	while (!q.empty()) {
		x = q.front().first; y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (map[nx][ny] == false) continue;
			if (d[nx][ny] != 0) continue;
			d[nx][ny] = val;
			q.push({ nx, ny });
		}
	}
}
void dist(int x, int y) {
	int val = d[x][y];
	for (int i = 0; i < 4; i++){
		int nx = x; int ny = y;
		int dis = 0;
		while (1) {
			nx += dx[i]; ny += dy[i];
			dis += 1;
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
			if (d[nx][ny] == val) break;
			if (d[nx][ny] != 0 && map[nx][ny] == true) {
				if (dis - 1< 2) break;
				else {
					geri[val][d[nx][ny]] = dis - 1 < geri[val][d[nx][ny]] ? dis - 1: geri[val][d[nx][ny]];
					break;
				}
			}
		}
	}
}
int getParent(int x) {
	if (parent[x] == x) {
		return x;
	}
	return parent[x] = getParent(parent[x]);
}
bool findParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a == b) {
		return false;
	}
	else {
		if (a < b)
			parent[b] = a;
		else parent[a] = b;
		return true;
	}
}
int main() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) scanf("%d", &map[i][j]);
	int island = 1;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] && d[i][j] == 0) {
				bfs(i, j, island++);
			}
		}
	}
	for (int i = 1; i < island; i++) {
		for (int j = 1; j < island; j++)
			geri[i][j] = 987654321;
	}
	for (int i = 1; i < island; i++) {
		parent[i] = i;
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (d[i][j] == 0) continue;
			dist(i, j);
		}
	}
	vector<Node> nd;
	for (int i = 1; i < island; i++) {
		for (int j = i; j < island; j++) {
			if (i == j) continue;
			if (geri[i][j] == 987654321) continue;
			nd.push_back({ i, j, geri[i][j] });
			nd.push_back({ j, i, geri[i][j] });
		}
	}
	sort(nd.begin(), nd.end());
	int ans = 0;
	for (int i = 0; i < nd.size(); i++) {
		if (findParent(nd[i].node[0], nd[i].node[1])) {
			ans += nd[i].val;
		}
	}
	int now = getParent(1);
	for (int i = 2; i < island; i++) {
		if (now != getParent(i)) {
			ans = -1;
			break;
		}
	}
	printf("%d", ans);
	
}
