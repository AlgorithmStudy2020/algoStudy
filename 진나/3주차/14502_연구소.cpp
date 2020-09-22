#include<iostream>
#include<queue>
#include<vector>
#include<memory.h>

#define MAX 10
using namespace std;

int N, M, input[MAX][MAX], copying[MAX][MAX];

//상하좌우
int dy[4] = {-1,1,0,0},dx[4] = {0,0,-1,1};
int visited[MAX][MAX];
int result = 0;
queue<pair<int, int>> virus;
int spread_virus() {
	
	

	int nexty, nextx, cury, curx;
	while (!virus.empty()) {
		cury = virus.front().first; curx = virus.front().second;
		virus.pop();
		visited[cury][curx] = 1;
		
		for (int i = 0; i < 4; i++) {
			nexty = cury + dy[i]; nextx = curx + dx[i];
			if (nexty < 0 || nexty >= N || nextx < 0 || nextx >= M)	continue;
			if (!visited[nexty][nextx] && copying[nexty][nextx] == 0) {
				copying[nexty][nextx] = 2;
				visited[nexty][nextx] = 1;
				virus.push(make_pair(nexty, nextx));
			}

		}
	}

	//안전영역 구하기
	int size = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (copying[i][j] == 0)	size++;
		}
	}
	return size;
}

void setWall(int cnt) {
	//base case
	if (cnt == 3) {
		int temp=spread_virus();
		if (temp > result)	result = temp;
		return;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (input[i][j] != 0)	continue;

			copying[i][j] = 1;
			setWall(cnt+1);
			copying[i][j] = 0;
		}
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> input[i][j];
		}
	}

	//배열 복사
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			copying[i][j] = input[i][j];
			if (input[i][j] == 2)	virus.push(make_pair(i, j));
		}
	}

	cout << result << endl;
}