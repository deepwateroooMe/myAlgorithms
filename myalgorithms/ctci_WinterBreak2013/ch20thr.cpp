#include <iostream>
#include <cstdlib>
using namespace std;

void swap(int &a, int &b) {
    int t = a; 
    a = b;
    b = t;
}

void PickMRandomly(int a[], int n, int m) {
    for (int i = 0; i < m; ++i) {
	int j = rand() % (n-i) + i;
	swap(a[i], a[j]);
    }
}

int main() {
    srand( (unsigned)time(0) );
    int n = 9, m = 5;
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    PickMRandomly(a, n, m);
    for (int i = 0; i < m; ++i) 
	cout << a[i] << endl;
    return 0;
}
