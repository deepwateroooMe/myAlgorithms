#include <iostream>
using namespace std;

void merge(int a[], int m, int b[], int n) {
    if (n == 0) return;
    else if (m == 0) {
        for (int i = 0; i < n; ++i)
            a[i] = b[i];
        return;
    }
    else if (m == 1 && n ==1)  {
        if (a[0] > b[0]) {
            a[1] = a[0];
            a[0] = b[0];
        } else
            a[1] = b[0];
        return;
    }

    int i = m-1, j = n-1, k = m+n-1;
    while(i >= 0 && j >= 0) {
        if (a[i] < b[j]) {
            a[k] = b[j];
            --k; --j;
        } else if (a[i] > b[j]){        
            a[k] = a[i];
            --k; --i;
        } else if (a[i] == b[j]) {        
            a[k] = b[j];
            --k; --j;
            a[k] = a[i];
            --k; --i;
        }
    }
    //if (i < 0 && j > 0) {  // got wrong here before
    if (i < 0 && j >= 0) {    
        for (int x = 0; x <= j; ++x)
            a[x] = b[x];
    }
}

int main() {
    int m = 3, n = 6;   // runtime error, don't know why
    int a[] = {0, 0, 3, 0, 0, 0, 0, 0, 0};
    int b[] = {-1, 1, 1, 1, 2, 3};

    cout << "a: ";
    for (int i = 0; i < m; ++i)
        cout << a[i] << ", ";
    cout << endl;
    cout << "b: ";
    for (int i = 0; i < n; ++i)
        cout << b[i] << ", ";
    cout << endl;
    
    merge(a, m, b, n);
    for (int i = 0; i < m+n; ++i)
        cout << a[i] << ", ";
    cout << endl;

    return 0;
}
