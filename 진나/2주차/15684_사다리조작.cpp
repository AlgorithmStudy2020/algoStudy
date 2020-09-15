#include<iostream>

#define NMAX 10
#define HMAX 30

using namespace std;


int input[NMAX+1][HMAX+1];
int main() {
	int N, M, H; //세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선 놓을 수 있는 위치의 개수 H
	cin >> N >> M >> H;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		input[a][b] = b + 1;
		input[a][b + 1] = b;
	}

	/*
	for (int i = 1; i <= H; i++) {
		for (int j = 1; j <= M; j++) {
			cout << input[i][j] << " ";
		}cout << endl;
	}*/

}