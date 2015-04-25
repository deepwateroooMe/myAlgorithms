#include <iostream>
#include <cstdio>
using namespace std;

const int MAX_N = 100;
int p[MAX_N][MAX_N], A[MAX_N][MAX_N];

void PreCompute(int n){
    for (int i = 0; i <= n; ++i)
	p [0][i] = p[i][0] = 0;
    for (int i = 1; i <= n; ++i)
	for (int j = 1; j <= n; ++j)
	    p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + A[i][j];
}

int MaxSum(int n) {
    int max_sum = 1 << 31; // Min Int
    for (int i = 1; i <= n; ++i) 
	for (int j = 1; j <= n; ++j) {
	    int curr_sum = 0;
	    for (int k = 1; k <= n; ++k) {
		int val = p[j][k] - p[j][k-1] - p[i-1][k] + p[i-1][k-1];
		if (curr_sum <= 0) 
		    curr_sum = val;
		else
		    curr_sum += val;
		if (curr_sum > max_sum)
		    max_sum = curr_sum;
	    }
	}
    return max_sum;
}

int main() {
    freopen("ch20.12.in", "r", stdin);
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i) 
	for (int j = 1; j <= n; ++j)
	    cin >> A[i][j];
    PreCompute(n);
    cout << MaxSum(n) << endl;
    fclose(stdin);
    return 0;
}
