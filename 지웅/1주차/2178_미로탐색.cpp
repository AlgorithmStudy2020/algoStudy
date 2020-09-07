#include<iostream>
#include<queue>

using namespace std;

int n, m;
string map[100];
int d[100][100];
int dx[] = { 0,0,1,-1 }; int dy[] = { 1,-1,0,0 };

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> map[i];
	}
	queue<pair<int, int> > q;
	q.push({ 0,0 });
	d[0][0] = 1;
	while (!q.empty()) {
		int x = q.front().first; int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
			if (map[nx][ny] == '0') continue;
			if (d[nx][ny] != 0) continue;
			q.push({ nx, ny });
			d[nx][ny] = d[x][y] + 1;
		}
	}
	cout << d[n - 1][m - 1] << '\n';
	return 0;
}
