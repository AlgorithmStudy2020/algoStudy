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
	//��Ϲ����� ���� �Է¹���
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
		cin >> temp1 >> temp2;	//��Ϲ��� ��ȣ, ����(1:�ð����, -1:�ݽð����)
		rotateInfo.push_back({ temp1,temp2 });
	}
}

void rotate(int idx,int dir) {
	if (dir == 1) {//�ð����
		int temp = gearInfo[idx].back();
		gearInfo[idx].pop_back();
		gearInfo[idx].push_front(temp);
	}
	else {//�ݽð����
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
		simulate(rotateInfo[i].first-1, rotateInfo[i].second);	//�ε���,����
	}

	int sum = 0;
	for (int i = 0; i < 4; i++) {
		if (gearInfo[i].front() == 1) sum += pow(2, i);
	}
	cout << sum;

}