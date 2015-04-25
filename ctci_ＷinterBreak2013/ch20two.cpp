#include <iostream>
#include <cstdlib>
using namespace std;

void swap(int &a, int &b) {
    int t = a;
    a = b;
    b = t;
}

void RandomShuffle(int a[], int n) {
    for (int i = 0; i < n; ++i) {
	int j = rand() % (n-i) + i; // [i, n-1]
	swap(a[i], a[j]);
    }
}

int main() {
    srand( (unsigned)time(0) );
    int n = 9;
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    RandomShuffle(a, n);
    for (int i = 0; i < 9; ++i)
	cout << a[i] << endl;
    return 0;
}
