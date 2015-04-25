#include <iostream>
#include <cstring>
#include <cstdio>
using namespace std;

void zero(int **a, int m, int n) {
    bool row[m], col[n];
    memset(row, 0, sizeof(row));   // seems to have problem LeetCode reference
    memset(col, 0, sizeof(col));
    for (int i = 0; i < m; ++i ) 
	for (int j = 0; j < n; ++j ) 
	    if (a[i][j] == 0) {
		row[i] = true; 
		col[j] = true;
	    }
    for (int i = 0; i < m; ++i ) {
	for (int j = 0; j < n; ++j ) {
	    if (row[i] || col[j])
		a[i][j] = 0;
	}
    }
}

int main() {
    freopen("sev.txt", "r", stdin);

    int m, n;
    cin >> m >> n;
    int **a; 
    for (int i = 0; i < m; ++i )
	a[i] = new int[n];
    for (int i = 0; i < m; ++i ){
	for (int j = 0; j < n; ++j ) {
	    cin >> a[i][j]; 
	}
    }

    for (int i = 0; i < m; ++i ) {
	for (int j = 0; j < n; ++j ) {
	    cout << a[i][j] << '\t';
	}
	cout << endl;
    }
    cout << endl;

    zero(a, m, n);
    for (int i = 0; i < m; ++i ) {
	for (int j = 0; j < n; ++j ) {
	    cout << a[i][j] << '\t';
	}
	cout << endl;
    }

    fclose(stdin);
    return 0;
}
