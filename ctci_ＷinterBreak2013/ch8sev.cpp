#include <iostream>
using namespace std;

int cnt = 0;
void sumn(int sum, int c, int n) {
    if (sum >= n) {
	if (sum == n) ++cnt;
	return;
    } else {
	if (c >= 25) sumn(sum+25, 25, n);
	if (c >= 10) sumn(sum+10, 10, n);
	if (c >= 5) sumn(sum+5, 5, n);
	if (c >= 1) sumn(sum+1, 1, n);
    }
}

int sum_n(int sum, int c, int n) {
    int ways = 0;
    if (sum <= n) {
	if (sum == n) return 1;
	if (c >= 25) ways += sum_n(sum+25, 25, n);
	if (c >= 10) ways += sum_n(sum+10, 10, n);
	if (c >=  5) ways += sum_n(sum+ 5,  5, n);
	if (c >=  1) ways += sum_n(sum+ 1,  1, n);
    }
    return ways;
}

int make_change(int n, int denom) {
    int next_denom = 0;
    switch (denom) {
    case 25:
	next_denom = 10;
	break;
    case 10:
	next_denom = 5;
	break;
    case 5:
	next_denom = 1;
	break;
    case 1:
	return 1;
    }
    int ways = 0;
    for (int i = 0; i*denom <= n; ++i)
	ways += make_change(n-i*denom, next_denom);
    return ways;
}

int main() {
    int n = 10;
    sumn(0, 25, n);
    cout << "cnt: " << cnt << endl;

    cout << make_change(n, 25) << endl;
    cout << sum_n(0, 25, n) << endl;
    return 0;
}
