#include<iostream>
#include<vector>
#include<queue>
#include<tuple>
#include<algorithm>

#define NMAX 201
#define KMAX 1001
using namespace std;

class Virus {
public:
	int index;
	int second;
	int x;
	int y;
	Virus(int index, int second, int y, int x) {
		this->index = index;
		this->second = second;
		this->x = x;
		this->y = y;
	}
	// 정렬 기준은 '번호가 낮은 순서'
	bool operator <(Virus& other) {
		return this->index < other.index;
	}
};

int N, K,S,X,Y;	//N*N, 바이러스번호:K이하
int map[NMAX][NMAX];
int dInfo[4][2] = { {-1,0},{1,0},{0,-1},{0,1} };	//상,하,좌,우
vector<Virus> virusInfoV;
queue<Virus> virusInfo;
void init() {
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++){
			int temp;
			cin >> temp;
			if (temp != 0) {	//바이러스 좌표 정보 저장
				map[i][j] = temp;
				virusInfoV.push_back(Virus(temp, 0, i, j));
			}
		}
	}
	sort(virusInfoV.begin(), virusInfoV.end());
	for (int i = 0; i < virusInfoV.size(); i++) {
		virusInfo.push(virusInfoV[i]);
	}
	cin >> S >> X >> Y;
}

void bfs() {
	while (!virusInfo.empty()) {	//S초동안
		Virus virus = virusInfo.front();
		virusInfo.pop();
		if (virus.second == S) break;

		for (int j = 0; j < 4; j++) {
			int nexty = virus.y + dInfo[j][0]; int nextx = virus.x + dInfo[j][1];
			if (nexty<1 || nextx<1 || nexty>N || nextx>N) continue;
			if (map[nexty][nextx] == 0) {
				map[nexty][nextx] =virus.index;
				virusInfo.push(Virus(virus.index,virus.second+1,nexty,nextx));
			}
		}
	}
}

int main() {
	init();
	bfs();
	cout << map[X][Y];
}