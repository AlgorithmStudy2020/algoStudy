#include<iostream>

using namespace std;


int n;
unsigned long long a[1001][4];

unsigned long long d[1001][4];

unsigned long long min(unsigned long long a, unsigned long long b){
    unsigned long long min = a;
    if(min > b){
        min = b;

    }
    return min;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= 3; j++){
            cin>>a[i][j];
        }
    }

    d[1][1] = a[1][1]; d[1][2] = a[1][2]; d[1][3] = a[1][3];

    for(int i = 2; i <= n; i++){
        d[i][1] =min(d[i-1][2], d[i-1][3]) + a[i][1];
        d[i][2] = min(d[i-1][3], d[i-1][1]) + a[i][2];
        d[i][3] = min(d[i-1][1], d[i-1][2]) + a[i][3];
    }
    unsigned long long max = d[n][1];
    for(int i = 2; i <= 3; i++){
        if(max > d[n][i])
            max = d[n][i];
    }
    cout<<max<<'\n';

    return 0;

}
