#include <iostream>
#include <algorithm>

using namespace std;

int removeDuplicates(int a[], int n) {
    return distance(a, unique(a, a + n));
}

int removeDuplicates0(int a[], int n) {
    if (n == 0) return n;
    int cnt = 0; 
    bool flag = false;
    int i;
    
    for ( i = 1; i < n; ++i) {
        while (a[i] == a[cnt]) {
            if (i < n-1) 
                ++i;
            else  {
                flag = true;
                break;
            }
        }
        if (!flag)
            a[++cnt] = a[i];
    }

    if (i < n && a[i] == a[cnt])
        return cnt;
    else
        return cnt+1;    
}

int main() {
    int m = 4;
    int a[] = {-3, -1, 0, 0};

    cout << "a: ";
    for (int i = 0; i < m; ++i)
        cout << a[i] << ", ";
    cout << endl;
    
    int result = removeDuplicates(a, m);
    cout << "result: " << result << endl;
    for (int i = 0; i < result; ++i)
        cout << a[i] << ", ";
    cout << endl;
    
    return 0;
}

/*
Input:	[-3,-1,0,0]
Output:	[-3,-1]
Expected:	[-3,-1,0]
*/
