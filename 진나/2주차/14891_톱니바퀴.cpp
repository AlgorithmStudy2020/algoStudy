#include<iostream>
#include<deque>
#include<vector>
#include<math.h>
using namespace std;

int K;
deque <int> gearInfo[4];
bool visited[4];
vector<pair<int,int>> rotateInfo;
void init() {
	//톱니바퀴의 상태 입력받음
	for (int i = 0; i < 4; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			gearInfo[i].push_back(s[j] - '0');
		}
	}
	cin >> K;
	for (int i = 0; i < K; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;	//톱니바퀴 번호, 방향(1:시계방향, -1:반시계방향)
		rotateInfo.push_back({ temp1,temp2 });
	}
}

void rotate(int idx,int dir) {
	if (dir == 1) {//시계방향
		int temp = gearInfo[idx].back();
		gearInfo[idx].pop_back();
		gearInfo[idx].push_front(temp);
	}
	else {//반시계방향
		int temp = gearInfo[idx].front();
		gearInfo[idx].pop_front();
		gearInfo[idx].push_back(temp);
	}
}

void simulate(int idx,int rot) {
	visited[idx] = true;

	if (idx + 1 <4 && !visited[idx + 1]) {
		if (gearInfo[idx][2] != gearInfo[idx + 1][6]) {
			simulate(idx + 1, -rot);
		}
	}
	if (idx - 1 >=0 && !visited[idx - 1]) {
		if (gearInfo[idx][6] != gearInfo[idx - 1][2]) {
			simulate(idx - 1, -rot);
		}
	}

	visited[idx] = false;
	rotate(idx, rot);
}

int main() {
	ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
	
	init();

	for (int i = 0; i < K; i++) {
		simulate(rotateInfo[i].first-1, rotateInfo[i].second);	//인덱스,방향
	}

	int sum = 0;
	for (int i = 0; i < 4; i++) {
		if (gearInfo[i].front() == 1) sum += pow(2, i);
	}
	cout << sum;

}