#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int swap(int &a, int &b)  {
    int tmp = a;
    a = b;
    b = tmp;
}

int removeElement(int a[], int n, int elem) {
    if (n == 1 && a[0] == elem) return 0;
    //else if (n ==1) return 1;
    for (int i = 0; i < n; ++i)
        while (a[i] == elem) {
            if (i != n-1)
                swap(a[i], a[n-- - 1]);
            else
                return i;
        }
    return n;
}

int main(){
    int n = 3;
    int a[] = {2, 2, 2};
    
    int m = removeElement(a, n, 2);

    cout << "i: " << m << endl;
    for(int i = 0; i < m; ++i)
        cout << a[i] << ", ";
    cout << endl;
    
    return 0;
}
