#include<iostream>

using namespace std;

int han(int n) {
	if (n < 100)	return n;
	else {
		int hundred, ten, one,result=0;
		for (int i = 100; i <= n; i++) {
			hundred = i / 100; ten = (i % 100) / 10; one = (i % 100)%10;
			if ((hundred - ten) == (ten - one))	result++;
		}
		return (99+result);
	}
}

int main() {
	int N;
	cin >> N;
	cout<<han(N);

}