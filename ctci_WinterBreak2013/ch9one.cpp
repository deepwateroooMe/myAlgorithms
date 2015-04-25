#include <iostream>
using namespace std;

void merge(int a[], int b[], int n, int m) {  // O(m+n)
    int k = m + n -1; 
    int i = n-1, j = m-1;

    while (i >= 0 && j >= 0) {
	if (a[i] > b[j]) a[k--] = a[i--];
	else a[k--] = b[j--];
    }
    while (j >= 0) a[k--] = b[j--];
}

void swap(int &a, int &b) {
    a = a^b;
    b = a^b;
    a = a^b;
}

void merge(int a[], int begin, int mid, int end) {
    for (int i = begin; i <= mid; ++i) {
	if (a[i] > a[mid+1]) {
	    swap(a[i], a[mid+1]);

	    for (int j = mid+1; j < end; ++j) {
		if (a[j] <= a[j+1]) break;
		swap(a[j], a[j+1]);
	    }
	}
    }
}

int main() {
    int a[15] = {1, 5, 6, 7}; 
    int b[] = {2, 3, 4, 8, 10, 12, 14};
    int n = 4, m = 7;
    merge(a, b, 4, 7);
    for (int i = 0; i < m+n; ++i)
	cout << a[i] << " ";
    cout << endl;

    int a1[10] = {8, 9, 11, 15, 17, 1, 3, 5, 12, 18};
    merge(a1, 0, 4, 9);
    for (int i = 0; i < 10; ++i)
	cout << a1[i] << " ";
    cout << endl;
    return 0;
}
