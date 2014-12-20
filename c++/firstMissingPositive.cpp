#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

int firstMissingPositive(int a[], int n) {
    if (n == 0) return 1;
    else if (n == 1) {
        if (a[0] == 1) return 2;
        return 1;
    }

    bool nequ = false;
    for(int i = 0; i < n; ++i) {
        if (a[i] <= 0) continue;
        if (a[i] == n) {
            nequ = true;
            continue;
        }
        while ( (i == 0 || a[i] != i && i != 0) && a[i] > 0 && a[i] < n) {
            swap(a[i], a[a[i]]);
            if (a[i] >= 0 && a[i] == a[a[i]])
                break;
        }
    }

    for(int i = 1; i < n; ++i) {
        if (a[i] != i)
            return i;
    }
    if (nequ || a[0] == n) return n+1;
    return n;
}

int main(){
    int n = 3;
    int a[] = {1, 2, 3};
    cout << firstMissingPositive(a, n) << endl;

    return 0;
}
