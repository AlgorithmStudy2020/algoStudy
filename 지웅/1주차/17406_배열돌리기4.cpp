#include<iostream>
#include<vector>
#include<algorithm>
#include<cstdlib>
#include<cstring>
#define endl '\n'
using namespace std;

struct rot {
	int r, c, s;
};
int n, m, k;
int map[51][51];
int temp[51][51];
rot rotat[6];
int ans = 10000;
//x1 작은거 x2큰거 y1작은거 y2큰거
void rotation(int x1, int y1, int x2, int y2) {
	if (x1 == x2 && y1 == y2) {
		return;
	}
	int temp = map[x1][y1];
	//y1고정
	for (int i = x1; i < x2; i++) {
		map[i][y1] = map[i+1][y1];
	}
	int temp2 = map[x1][y2];
	for (int i = y2 -1 ; i >= y1; i--) {
		if (i == y1)
			map[x1][i + 1] = temp;
		else map[x1][i + 1] = map[x1][i];
	}
	//y2 고정
	temp = map[x2][y2];
	for (int i = x2; i > x1; i--) {
		if (i == x1 + 1) {
			map[i][y2] = temp2;
		}
		else map[i][y2] = map[i-1][y2];
	}
	
	for (int i = y1; i < y2; i++) {
		if (i == y2 - 1) {
			map[x2][i] = temp;
		}
		else
		{
			map[x2][i] = map[x2][i + 1];
		}
	}
	rotation(x1 + 1, y1 + 1, x2 - 1, y2 - 1);
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
	cin >> n >> m >> k;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
			temp[i][j] = map[i][j];
		}
	}

	for (int i = 0; i < k; i++) {
		int r, c, s;
		cin >> r >> c >> s;
		rotat[i].r = r;
		rotat[i].c = c;
		rotat[i].s = s;
	}
	

	vector<int> u;
	for (int i = 0; i < k; i++) {
		u.push_back(i);
	}
	do {
		memcpy(map, temp, sizeof(map));
		for (int i = 0; i < k; i++) {
			rotation(rotat[u[i]].r - rotat[u[i]].s, rotat[u[i]].c - rotat[u[i]].s, rotat[u[i]].r + rotat[u[i]].s, rotat[u[i]].c + rotat[u[i]].s);
		}
		/*cout << endl;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}*/
		for (int i = 1; i <= n; i++) {
			int temp = 0;
			for (int j = 1; j <= m; j++) {
				temp += map[i][j];
			}
			if (temp < ans) ans = temp;
		}
	} while (next_permutation(u.begin(), u.end()));

	cout <<ans<< endl;
	
	return 0;


}
