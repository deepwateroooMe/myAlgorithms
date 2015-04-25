#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

const int maxn = 100;
struct person {
    int h; 
    int w;
};
person p[maxn];
int d[maxn];

bool cmp(person p1, person p2) {
    if (p1.h == p2.h) return p1.w < p2.w;
    else return p1.h < p2.h;
}

int lis(person p[], int n) {
    d[0] = p[0].w;
    int k = 1;
    for (int i = 1; i < n; ++i) {
	if (p[i].w >= d[k-1]) 
	    d[k++] = p[i].w;
	else { // binary to get O(nlogn)  NOT understanding this partx
	    int j;
	    for (j = k-1; j >= 0 && d[j] > p[i].w; --j);
	    d[j+1] = p[i].w;
	}
    }
    return k;
}

int main() {
    freopen("ch99.7.in", "r", stdin);
    int n; 
    cin >> n;
    for (int i = 0; i < n; ++i)
	cin >> p[i].h >> p[i].w;
    sort(p, p+n, cmp);
    cout << lis(p, n) << endl;
    fclose(stdin);
    return 0;
}
