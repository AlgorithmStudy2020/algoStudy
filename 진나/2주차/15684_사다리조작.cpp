#include<iostream>

#define NMAX 10
#define HMAX 30

using namespace std;


int input[NMAX+1][HMAX+1];
int main() {
	int N, M, H; //���μ��� ���� N, ���μ��� ���� M, ���μ����� ���μ� ���� �� �ִ� ��ġ�� ���� H
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